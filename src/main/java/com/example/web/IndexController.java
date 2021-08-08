package com.example.web;

import com.example.config.auth.LoginUser;
import com.example.config.auth.dto.SessionUser;
import com.example.service.PostsService;
import com.example.service.RedisSampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@Slf4j
public class IndexController {

    private final PostsService postsService;
    private final HttpSession httpSession;
    @Autowired
    private RedisSampleService redisSampleService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
//        model.addAttribute("posts",postsService.findAllDesc());
//        redisSampleService.getRedisStringValue("banana");
        log.info("{}", user);
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

//    @GetMapping("/posts/save")
//    public String postsSave(Model model, @LoginUser SessionUser user){
//        model.addAttribute("posts",postsService.findAllDesc());
//
//        if(user != null){
//            model.addAttribute("userName", user.getName());
//        }
//        return "posts-save";
//    }
//
//    @GetMapping("posts/update/{id}")
//    public String postsUpdate(@PathVariable Long id, Model model, @LoginUser SessionUser user){
//        PostsResponseDto dto = postsService.findById(id);
//        model.addAttribute("post",dto);
//        model.addAttribute("posts",postsService.findAllDesc());
//
//        if(user != null){
//            model.addAttribute("userName", user.getName());
//        }
//        return "posts-update";
//    }
}
