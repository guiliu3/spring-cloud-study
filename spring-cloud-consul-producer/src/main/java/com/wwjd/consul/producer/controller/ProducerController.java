package com.wwjd.consul.producer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProducerController {
	
	@GetMapping("/get/{id}")
	public String get(@PathVariable String id) {
		return "liugui"+id;
	}

}
