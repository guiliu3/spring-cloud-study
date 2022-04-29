package com.wwjd.consumer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 第一个生产者的Ribbon负载配置类
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.consumer.config
 * @date 2022/4/29 14:54
 * @Copyright © 上海卓繁
 */
@Configuration
public class ConsumerRibbonConfig {


    @Bean
    public IRule ribbonRule(IClientConfig config) {
        ZoneAvoidanceRule rule = new ZoneAvoidanceRule();
        rule.initWithNiwsConfig(config);
        return rule;
    }

}
