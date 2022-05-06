package com.wwjd.consumer.feign.factory;

import com.wwjd.consumer.entity.User;
import com.wwjd.consumer.feign.UserClient1;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.consumer.feign.factory
 * @date 2022/5/6 20:39
 * @Copyright © 上海卓繁
 */
@Component
public class UserClient1Factory implements FallbackFactory<UserClient1> {
    @Override
    public UserClient1 create(Throwable throwable) {
        return new UserClient1() {
            @Override
            public String get(String id) {
                return "fall factory get Method ,cause by:" + throwable.getMessage();
            }

            @Override
            public User getUser2(User user) {
                User errUser = new User();
                errUser.setName("err User Name");
                errUser.setId("err User Id");
                return errUser;
            }

            @Override
            public User postUser(User user) {
                User errUser = new User();
                errUser.setName("post err User Name");
                errUser.setId("post err User Id");
                return errUser;
            }
        };
    }
}
