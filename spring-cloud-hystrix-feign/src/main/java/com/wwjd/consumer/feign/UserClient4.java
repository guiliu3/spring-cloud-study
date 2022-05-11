package com.wwjd.consumer.feign;

import com.wwjd.config.FeignNoHystrixConfigure;
import com.wwjd.consumer.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.consumer.feign
 * @date 2022/5/5 19:28
 * @Copyright © 上海卓繁
 */
@FeignClient(name="cloud-producer4",configuration = FeignClientsConfiguration.class)
public interface UserClient4 {

    // @PathVariable必须指定value,且指定名称，否则异常:PathVariable annotation was empty on param 0.
    @GetMapping(value= "/get/{id}")
    String get(@PathVariable("id") String id);

    // 调用参数为复杂对象时，远程调用方法指定为Get请求时，会报错 "error":"Method Not Allowed"
    @GetMapping(value="/getuser2")
    User getUser2(User user);

    // 调用远程的post方法,如果参数为复杂对象,就算指定了method=RequestMethod.GET,依然会使用post方式请求
    @RequestMapping(value = "/postuser",method = RequestMethod.POST)
    User postUser(@RequestBody User user);
}