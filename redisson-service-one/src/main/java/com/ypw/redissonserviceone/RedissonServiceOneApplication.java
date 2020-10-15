package com.ypw.redissonserviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RedissonServiceOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedissonServiceOneApplication.class, args);
    }

}
