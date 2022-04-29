package com.wwjd.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 演示Ribbon 配置不通的负载策略模式，查看每次获取得到的服务实例
 *
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.consumer.controller
 * @date 2022/4/29 21:10
 * @Copyright © 上海卓繁
 */
@RestController
public class RibbonController {

    /**
     * 负载均衡客户端实现类
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/c/ribbon")
    public void ribbon() {
        //访问第一类生产者微服务
        ServiceInstance producer1 = loadBalancerClient.choose("cloud-producer");
        System.out.println("host:" + producer1.getHost() + "port:" + producer1.getPort() + "service_id:" + producer1.getServiceId() + "uri:" + producer1.getUri());
        // 访问第二个生产者微服务
        ServiceInstance producer2 = loadBalancerClient.choose("cloud-producer2");
        System.out.println("host:" + producer2.getHost() + "port:" + producer2.getPort() + "service_id:" + producer2.getServiceId() + "uri:" + producer2.getUri());
    }

    @GetMapping("/c/ribbon/producer1")
    public String ribbonCallProducer1() {
        //访问第一类生产者微服务
        ServiceInstance producer1 = loadBalancerClient.choose("cloud-producer");
        System.out.println("host:" + producer1.getHost() + "port:" + producer1.getPort() + "service_id:" + producer1.getServiceId() + "uri:" + producer1.getUri());
        return "producer1的获取实例成功";
    }

    @GetMapping("/c/ribbon/producer2")
    public String ribbonCallProducer2() {
        // 访问第二个生产者微服务
        ServiceInstance producer2 = loadBalancerClient.choose("cloud-producer2");
        System.out.println("host:" + producer2.getHost() + "port:" + producer2.getPort() + "service_id:" + producer2.getServiceId() + "uri:" + producer2.getUri());
        return "producer2的获取实例成功";
    }
}
