package com.wwjd.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard //  开启仪表盘
@EnableTurbine // 开启聚集监控
public class TurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(TurbineApplication.class, args);
	}
}
