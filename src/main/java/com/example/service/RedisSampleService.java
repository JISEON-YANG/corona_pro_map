package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RedisSampleService {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void getRedisStringValue(String key){

        ValueOperations<String, String> stringValueOperations = stringRedisTemplate.opsForValue();
        log.info("{}", key);
        log.info("{}", stringValueOperations.get(key));
    }

}
