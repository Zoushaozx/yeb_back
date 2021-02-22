package com.zoux.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置类
 */
@Configuration
public class RedisConfig {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        //序列化
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // String类型key序列器
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        // String类型value序列器
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());

        // Hash类型key序列器
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // Hash类型value序列器
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        return redisTemplate;
    }
}
