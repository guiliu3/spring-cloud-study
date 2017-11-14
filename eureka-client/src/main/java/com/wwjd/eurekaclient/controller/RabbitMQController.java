package com.wwjd.eurekaclient.controller;

import com.wwjd.eurekaclient.rabbitmq.Send;
import com.wwjd.eurekaclient.rabbitmq.SendHasCallBack;
import com.wwjd.eurekaclient.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 董朱旭
 * @version BUILD1001
 * @fileName com.wwjd.eurekaclient.controller.RabbitMQControlle.java
 * @CopyRright (c) 2017-bxm：杭州微财科技有限公司
 * @created 2017-11-14 13:36:00
 * @modifier 董朱旭
 * @updated 2017-11-14 13:36:00
 * @description
 */
@RestController
public class RabbitMQController {

    @Autowired
    private Send send;

    @Autowired
    private SendHasCallBack sendHasCallBack;

    @GetMapping("/rabbit")
    public ResultUtil<String> sendMsg(@RequestParam(name = "msg") String msg){
        send.sendMsg(msg);
        return new ResultUtil<>(1200,"ok!",msg);
    }
    @GetMapping("/rabbit/callbacl")
    public ResultUtil<String> sendMsgCallback(@RequestParam(name = "msg") String msg){
        sendHasCallBack.sendMsg(msg);
        return new ResultUtil<>(1200,"ok!",msg);
    }
}
