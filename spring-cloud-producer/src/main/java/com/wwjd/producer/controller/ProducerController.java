package com.wwjd.producer.controller;

import com.wwjd.producer.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProducerController {

    @GetMapping("/get/{id}")
    public String get(@PathVariable String id) {
        return "liugui" + id;
    }

    @GetMapping("/getuser/{id}")
    public User getUser(@PathVariable String id) {
        System.out.println("getUser.....");
        User user = new User();
        user.setId(id);
        return user;
    }

    @PostMapping("/postuser")
    public User postUser(@RequestBody User user) {
        System.out.println("postUser.....");
        return user;
    }

    @GetMapping("/getuser2")
    public User getUser2(User user) {
        System.out.println("getUser2.....");
        return user;
    }

    @GetMapping("/listAll")
    public List<User> listAll() {
        List<User> users = new ArrayList<User>();
        users.add(new User("1", "zhangsan"));
        users.add(new User("2", "wangwu"));
        users.add(new User("3", "lisi"));
        return users;
    }
}
