package com.wwjd.consumer.controller;

import com.wwjd.consumer.entity.User;
import com.wwjd.consumer.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feign")
public class ConsumerController {
	
	@Autowired
	private UserClient userClient;
	
	@GetMapping("/c/get/{id}")
	public String get(@PathVariable String id) {
		return userClient.get(id);
	}

	@GetMapping("/c/getuser2")
	public User get(User user) {
		return userClient.getUser2(user);
	}

	@RequestMapping("/c/postUser")
	public User postUser(@RequestBody User user) {
		return userClient.postUser(user);
	}

}
