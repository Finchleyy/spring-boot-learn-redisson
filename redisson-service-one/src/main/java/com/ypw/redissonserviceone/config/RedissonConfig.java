package com.ypw.redissonserviceone.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yupengwu
 */
@Configuration
public class RedissonConfig {

    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useClusterServers()
                // 集群状态扫描间隔时间，单位是毫秒
                .setScanInterval(2000)
                //可以用"rediss://"来启用SSL连接
                .addNodeAddress("redis://192.168.100.107:7001",
                        "redis://192.168.100.107:7002",
                        "redis://192.168.100.107:7003",
                        "redis://192.168.100.107:7004",
                        "redis://192.168.100.107:7005",
                        "redis://192.168.100.107:7006")
                .setPassword("123456");
        return Redisson.create(config);
    }
}
