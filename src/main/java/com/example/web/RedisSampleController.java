package com.example.web;

import com.example.service.RedisSampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisSampleController {
    @Autowired
    private RedisSampleService redisSampleService;

    @GetMapping(value = "/getRedisStringValue")
    public void getRedisStringValue(String key) {
        redisSampleService.getRedisStringValue("banana");
    }
}
