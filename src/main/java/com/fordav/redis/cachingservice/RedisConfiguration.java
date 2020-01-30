package com.fordav.redis.cachingservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, User> getRedisTemplate() {
        RedisTemplate<String, User> objectObjectRedisTemplate = new RedisTemplate<>();
        objectObjectRedisTemplate.setConnectionFactory(getRedisConnectionFactory());
        return objectObjectRedisTemplate;
    }

    @Bean
    public JedisConnectionFactory getRedisConnectionFactory() {
        return new JedisConnectionFactory();
    }
}
