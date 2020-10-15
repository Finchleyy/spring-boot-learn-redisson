package com.ypw.springbootlearnredisson;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringBootLearnRedissonApplication.class)
@RunWith(SpringRunner.class)
public class SpringBootLearnRedissonApplicationTests {
    @Autowired
    RedissonClient redissonClient;

    @Test
    public void contextLoads() {
        RLock lock = redissonClient.getLock("anyLock");
        //最常见的使用方法
        lock.lock();
        lock.unlock();

    }

}
