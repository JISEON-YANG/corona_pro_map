package com.example.web;

import com.example.config.auth.LoginUser;
import com.example.config.auth.dto.SessionUser;
import com.example.service.RedisSampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
public class RedisSampleController {

    private final HttpSession httpSession;

    @Autowired
    private RedisSampleService redisSampleService;

    @GetMapping(value = "/getRedisStringValue")
    public void getRedisStringValue(String key) {
        redisSampleService.getRedisStringValue("banana");
    }

    @GetMapping("/session")
    public String getSession(){
        System.out.println(httpSession.getId());
        return httpSession.getId();
    }
    @GetMapping("/setsession")
    public void setSession(){
        httpSession.setAttribute("username", "testman");
    }

}
