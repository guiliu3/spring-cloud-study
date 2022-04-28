#SpringCloud学习
##1. Eureka知识
### 1.1 Eureka-server 增加 security认证
    第一步、引入对应的pom依赖，并在yml文件中，加入安全验证的账号和密码
    第二步、eureka-client在访问服务端时，需要在url中加入账号名和密码
### 1.2 Eureka-server 自我注册问题
    在application.yml配置文件中，增加如下配置：
    eureka.client.register-with-eureka    //表示是否将自己注册到Eureka Server
    eureka.client.fetch-registry         //表示是否从Eureka Server获取注册的服务信息
### 1.3 Eureka-server 仪表盘
    默认仪表盘是开启的，可通过配置文件去禁用，或者修改仪表盘的访问path
    dashboard:   # 仪表盘的path设置和是否开启设置，默认是开启的，访问地址默认是ip:port
        path: /dashboard
        enabled: true
### 1.4 Eureka 的架构图
![架构图](img/eruka架构图.jpg)

