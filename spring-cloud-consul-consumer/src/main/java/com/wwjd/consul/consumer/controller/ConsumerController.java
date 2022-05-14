package com.wwjd.consul.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/c/get/{id}")
	public String get(@PathVariable String id) {
		String result = restTemplate.getForObject("http://spring-cloud-consul-producer/get/"+id, String.class);
		return result;
	}
	
}
