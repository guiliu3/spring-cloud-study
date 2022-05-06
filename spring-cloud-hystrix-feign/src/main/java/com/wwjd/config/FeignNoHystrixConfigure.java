package com.wwjd.config;

import feign.Feign;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.consumer.config
 * @date 2022/5/6 21:19
 * @Copyright © 上海卓繁
 */
@Configuration
public class FeignNoHystrixConfigure {

    @Bean
    @Scope("prototype")
    public Feign.Builder feignBuilder(Retryer retryer) {
        return Feign.builder();
    }
}
