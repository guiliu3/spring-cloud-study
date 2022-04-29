package com.wwjd.consumer.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 第二个生产者的Ribbon负载配置类，随机分配
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.consumer.config
 * @date 2022/4/29 14:54
 * @Copyright © 上海卓繁
 */
@Configuration
public class ConsumerRibbonConfig2 {


    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }

}
