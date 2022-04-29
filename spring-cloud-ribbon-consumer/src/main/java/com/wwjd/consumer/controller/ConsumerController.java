package com.wwjd.consumer.controller;

import com.wwjd.consumer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonLoadBalancerClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ConsumerController {
	
	@Autowired
	private RestTemplate restTemplate;

	/**
	 * 负载均衡客户端实现类
	 */
	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("/c/get/{id}")
	public String get(@PathVariable String id) {
		String result = restTemplate.getForObject("http://cloud-producer/get/"+id, String.class);
		return result;
	}

	@GetMapping("/c/getuser/{id}")
	public User getUser(@PathVariable String id) {
		User result = restTemplate.getForObject("http://cloud-producer/getuser/"+id, User.class);
		return result;
	}
	
	@PostMapping("/c/postuser")
	public User postUser(@RequestBody User user) {
		User result = restTemplate.postForObject("http://cloud-producer/postuser", user, User.class);
		return result;
	}
	
	@GetMapping("/c/listAll")
	public List<User> listAll(){
		List<User> result = restTemplate.getForObject("http://cloud-producer/listAll", List.class);
		return result;
	}

	@GetMapping("/c/ribbon")
	public void ribbon(){
		//访问第一类生产者微服务
		ServiceInstance producer1 = loadBalancerClient.choose("cloud-producer");
		System.out.println("host:"+producer1.getHost()+"port:"+producer1.getPort()+"service_id:"+producer1.getServiceId()+"uri:"+producer1.getUri());
		// 访问第二个生产者微服务
		ServiceInstance producer2 = loadBalancerClient.choose("cloud-producer2");
		System.out.println("host:"+producer2.getHost()+"port:"+producer2.getPort()+"service_id:"+producer2.getServiceId()+"uri:"+producer2.getUri());
	}
}
