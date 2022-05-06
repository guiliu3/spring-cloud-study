package com.wwjd.consumer.controller;

import com.wwjd.consumer.entity.User;
import com.wwjd.consumer.feign.UserClient4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 通过Feign 配置不启用Hystrix.观察调用接口，是否跟Client3调用结果一致。会报no fallback available
 * 结果: 未报no fallback available ,而是报 Load balancer does not have available server for client: cloud-producer4，说明已经达到了禁用Hystrix的效果。
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.consumer.controller
 * @date 2022/5/6 20:44
 * @Copyright © 上海卓繁
 */
@RestController
public class ConsumerTest4Controller {

    @Autowired
    private UserClient4 userClient4;

    @GetMapping("/feign4/get/{id}")
    public String get(@PathVariable String id) {
        return userClient4.get(id);
    }

    @GetMapping("/feign4/getuser2")
    public User get(User user) {
        return userClient4.getUser2(user);
    }

    @RequestMapping("/feign4/postUser")
    public User postUser(@RequestBody User user) {
        return userClient4.postUser(user);
    }
}
