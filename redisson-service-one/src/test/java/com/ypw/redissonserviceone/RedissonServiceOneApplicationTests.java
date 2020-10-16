package com.ypw.redissonserviceone;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = RedissonServiceOneApplication.class)
class RedissonServiceOneApplicationTests {
    @Autowired
    RedissonClient redissonClient;

    @Test
    void contextLoads() {
        RBucket<Object> result = this.redissonClient.getBucket("123");
        System.out.println(result.get());
        if (!result.isExists()) {
            result.set("i am test value", 5, TimeUnit.MINUTES);
        }

    }

}
