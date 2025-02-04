package com.wwjd.consul.producer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducerApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(ProducerApplication.class).web(true).run(args);
	}
	
}
