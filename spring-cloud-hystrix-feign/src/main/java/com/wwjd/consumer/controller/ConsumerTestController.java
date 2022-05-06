package com.wwjd.consumer.controller;

import com.wwjd.consumer.entity.User;
import com.wwjd.consumer.feign.UserClient1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.consumer.controller
 * @date 2022/5/6 20:44
 * @Copyright © 上海卓繁
 */
@RestController
public class ConsumerTestController {

    @Autowired
    private UserClient1 userClient1;

    @GetMapping("/c/get/{id}")
    public String get(@PathVariable String id) {
        return userClient1.get(id);
    }

    @GetMapping("/c/getuser2")
    public User get(User user) {
        return userClient1.getUser2(user);
    }

    @RequestMapping("/c/postUser")
    public User postUser(@RequestBody User user) {
        return userClient1.postUser(user);
    }
}
