package com.wwjd.consumer.feign.impl;

import com.wwjd.consumer.entity.User;
import com.wwjd.consumer.feign.UserClient;
import org.springframework.stereotype.Component;

/**
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.consumer.feign.impl
 * @date 2022/5/6 20:23
 * @Copyright © 上海卓繁
 */
@Component
public class UserClientImpl implements UserClient {

    @Override
    public String get(String id) {
        return "hystrix fallback for get method";
    }

    @Override
    public User getUser2(User user) {
        User errUser = new User();
        errUser.setId("errId");
        errUser.setName("errName");
        return errUser;
    }

    @Override
    public User postUser(User user) {
        User errUser = new User();
        errUser.setId("errId post");
        errUser.setName("errName1 post");
        return errUser;
    }
}
