package com.ypw.redissonservicetwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedissonServiceTwoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedissonServiceTwoApplication.class, args);
    }

}
