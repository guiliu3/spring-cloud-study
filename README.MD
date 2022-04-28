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

### 1.4 Eureka的自我保护机制
    Eureka服务端会检查最近15分钟内的所有Eureka实例正常心跳比例,如果低于85%,则会触发保护机制，短暂性的将失效的
    失效的服务保护起来，不会删除、也不会过期，但是这些服务不是永远不会过期，Eureka服务端会每隔60s检查下服务的健康状态，
    若这些失效的服务在90s后还未恢复，则将这些服务从注册表中剔除。并关闭自我保护机制。
    
    为什么会有自我保护机制的原因：
        有些Eureka客户端是正常使用，但是由于网络问题，导致Eureka服务端和客户端无法进行正常通信，而导致的心跳检测失败。
      从而将客户端服务从注册表中剔除，不太合理，因为Eureka客户端只有在服务启动的时候，才会向Eureka服务端端注册。从而增加自我保护机制。
      
     通过以下配置关闭自我保护机制，默认是开启自我保护机制
     eureka.server.enable-self-preservation = false
     
### 1.5 单机高可用
    详情查看eureka服务端单机高可用配置文件

### 1.6 多机高可用
