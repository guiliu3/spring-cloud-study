package com.wwjd.eurekaribbon.controller;

import com.alibaba.fastjson.JSON;
import com.wwjd.eurekaribbon.service.CommonService;
import com.wwjd.eurekaribbon.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class CommonControler {

    @Autowired
    CommonService commonService;

    /**
     * 拦截所有的 GET 请求
     * @author 董朱旭
     * @time 2017/11/9
     * @CopyRight 杭州微财网络科技有限公司
     * @param request
     * @param response
     * @return java.lang.String
     */
    @GetMapping( "/**")
    public ResultUtil get(HttpServletRequest request, HttpServletResponse response){
        //消息头设置
        response.setContentType("application/json;charset=UTF-8");
        //调用服务层
        return commonService.get(request);
    }

    /**
     * 处理所有的 post 请求
     * @author 董朱旭
     * @time 2017/11/9
     * @CopyRight 杭州微财网络科技有限公司
     * @param request
     * @param response
     * @return java.lang.String
     */
    @PostMapping( "/**")
    public ResultUtil post(HttpServletRequest request, HttpServletResponse response){
        //消息头设置
        response.setContentType("application/json;charset=UTF-8");
        //调用服务层
        return commonService.post(request);
    }

    /**
     * 处理所有的 post 请求
     * @author 董朱旭
     * @time 2017/11/9
     * @CopyRight 杭州微财网络科技有限公司
     * @param request
     * @param response
     * @return java.lang.String
     */
    @PutMapping( "/**")
    public ResultUtil put(HttpServletRequest request, HttpServletResponse response){
        //消息头设置
        response.setContentType("application/json;charset=UTF-8");
        //调用服务层
        return commonService.put(request);
    }

    /**
     * 处理所有的 delete 请求
     * @author 董朱旭
     * @time 2017/11/9
     * @CopyRight 杭州微财网络科技有限公司
     * @param request
     * @param response
     * @return java.lang.String
     */
    @DeleteMapping( "/**")
    public ResultUtil delete(HttpServletRequest request, HttpServletResponse response){
        //消息头设置
        response.setContentType("application/json;charset=UTF-8");
        //调用服务层
        return commonService.delete(request);
    }

}