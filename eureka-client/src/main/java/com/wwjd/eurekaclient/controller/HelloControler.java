package com.wwjd.eurekaclient.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wwjd.eurekaclient.util.PutBody;
import com.wwjd.eurekaclient.util.ResultUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class HelloControler {

    @Value("${dao}")
    private String configValue;

    @Value("${my.word}")
    private String myWord;

    @GetMapping(value = "/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public ResultUtil<String> higet(@RequestParam(value = "time") String time) {
        return new ResultUtil(1200,"ok!",myWord+"get"+time+":"+configValue);
    }

    @PostMapping(value = "/hi")
    public ResultUtil<String> hipost( PutBody putBody) {
        return new ResultUtil(1200,"ok!",myWord+"post"+putBody.getTime());
    }

    @PutMapping(value = "/hi")
    public ResultUtil<String> hiput( PutBody putBody) {
        return new ResultUtil(1200,"ok!",myWord+"put"+putBody.getTime());
    }
    @DeleteMapping(value = "/hi")
    public ResultUtil<String> hidelete(@RequestParam(value = "time") String time) {
        return new ResultUtil(1200,"ok!",myWord+"delete"+time);
    }

    public ResultUtil<String> hiError(String name) {
        return new ResultUtil(1200,"failed!","hi,"+name+",sorry,error!");
    }

}