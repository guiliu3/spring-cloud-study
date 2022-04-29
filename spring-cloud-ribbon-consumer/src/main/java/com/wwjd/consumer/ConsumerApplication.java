package com.wwjd.consumer;

import com.wwjd.consumer.config.ConsumerRibbonConfig;
import com.wwjd.consumer.config.ConsumerRibbonConfig2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClientConfiguration;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
//@RibbonClients(
//		defaultConfiguration = RibbonClientConfiguration.class,
//		value = {
//				@RibbonClient(name="cloud-producer",configuration = ConsumerRibbonConfig.class),
//				@RibbonClient(name="cloud-producer2",configuration = ConsumerRibbonConfig2.class)
//
//})
public class ConsumerApplication {
	
	@Bean
	@LoadBalanced
    RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(com.wwjd.consumer.ConsumerApplication.class, args);
	}
	
}
