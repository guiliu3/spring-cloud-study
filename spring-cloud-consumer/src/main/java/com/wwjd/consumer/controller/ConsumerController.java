package com.wwjd.consumer.controller;

import com.wwjd.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/c/get/{id}")
	public String get(@PathVariable String id) {
		String result = restTemplate.getForObject("http://mima-cloud-consul-producer/get/"+id, String.class);
		return result;
	}
	
	@GetMapping("/c/getuser/{id}")
	public User getUser(@PathVariable String id) {
		User result = restTemplate.getForObject("http://mima-cloud-consul-producer/getuser/"+id, User.class);
		return result;
	}
	
	@PostMapping("/c/postuser")
	public User postUser(@RequestBody User user) {
		User result = restTemplate.postForObject("http://mima-cloud-consul-producer/postuser", user, User.class);
		return result;
	}
	
	@GetMapping("/c/listAll")
	public List<User> listAll(){
		List<User> result = restTemplate.getForObject("http://mima-cloud-consul-producer/listAll", List.class);
		return result;
	}
	
}
