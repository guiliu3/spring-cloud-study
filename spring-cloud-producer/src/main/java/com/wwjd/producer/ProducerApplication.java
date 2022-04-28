package com.wwjd.producer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProducerApplication {
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(com.wwjd.producer.ProducerApplication.class).web(true).run(args);
	}
	
}
