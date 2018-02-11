package com.dao.dubboserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * dubbo服务提供者
 *
 * @author 阿导
 * @version BUILD1001
 * @fileName PACKAGE_NAME.com.dao.dubboserver.SpringCloudDubboServerApplication.java
 * @CopyRright (c) 2018-万物皆导
 * @created 2018-02-10 09:54:00
 * @modifier 阿导
 * @updated 2018-02-10 09:54:00
 */

@SpringBootApplication
public class SpringCloudDubboServerApplication {
    public static void main(String[] args) {
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        SpringApplication.run(SpringCloudDubboServerApplication.class,args);
    }

}
