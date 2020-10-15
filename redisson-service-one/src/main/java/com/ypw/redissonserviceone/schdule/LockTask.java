package com.ypw.redissonserviceone.schdule;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @author yupengwu
 */
@Component
public class LockTask {
    @Autowired
    RedissonClient redissonClient;

    @Scheduled(cron = "0 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    //@Scheduled(fixedRate=5000)
    private void configureTasks() {
        System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
        RLock lock = redissonClient.getLock("someThreadTest");

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    lock.lock();
                    System.out.println(Thread.currentThread().getName() + "线程获取到锁🔐开始执行业务.....");
                    Thread.sleep(5000);
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "线程执行完毕.....");
            }).start();
        }
    }
}
