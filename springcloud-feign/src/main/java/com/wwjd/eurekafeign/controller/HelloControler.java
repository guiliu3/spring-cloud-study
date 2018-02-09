package com.wwjd.eurekafeign.controller;

import com.wwjd.eurekafeign.service.ClientService;
import com.wwjd.eurekafeign.util.PutBody;
import com.wwjd.eurekafeign.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloControler {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/ha")
    public ResultUtil<String> higet(String time){
        return clientService.higet(time);
    }

    @PostMapping("/ha")
    public ResultUtil<String> hipost( PutBody putBody){
        return clientService.hipost(putBody);
    }

    @PutMapping(value = "/ha")
    public ResultUtil<String> hiput( PutBody putBody){
        return clientService.hiput(putBody);
    }

    @DeleteMapping("/ha")
    public ResultUtil<String> hidelete(String time){
        return clientService.hidelete(time);
    }
}