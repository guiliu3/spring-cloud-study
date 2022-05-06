package com.wwjd.consumer.controller;

import com.wwjd.consumer.entity.User;
import com.wwjd.consumer.feign.UserClient3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 通过在FeginClient 不配置fallback，看是否能够达到禁用Hystrix
 * 结果：Feign默认是自动开启Hystrix，即使没有配置fallback，但是当服务不可达时，依然会提示 failed and no fallback available
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.consumer.controller
 * @date 2022/5/6 20:44
 * @Copyright © 上海卓繁
 */
@RestController
public class ConsumerTest3Controller {

    @Autowired
    private UserClient3 userClient3;

    @GetMapping("/feign3/get/{id}")
    public String get(@PathVariable String id) {
        return userClient3.get(id);
    }

    @GetMapping("/feign3/getuser2")
    public User get(User user) {
        return userClient3.getUser2(user);
    }

    @RequestMapping("/feign3/postUser")
    public User postUser(@RequestBody User user) {
        return userClient3.postUser(user);
    }
}
