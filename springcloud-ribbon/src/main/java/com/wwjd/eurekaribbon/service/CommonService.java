package com.wwjd.eurekaribbon.service;

import com.alibaba.fastjson.JSON;
import com.wwjd.eurekaribbon.util.RequstUtil;
import com.wwjd.eurekaribbon.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Service
public class CommonService {

    @Autowired
    RestTemplate restTemplate;

    /**
     * 处理 get 请求逻辑
     * @author 董朱旭
     * @time 2017/11/9
     * @CopyRight 杭州微财网络科技有限公司
     * @param request
     * @return com.wwjd.eurekaribbon.util.ResultUtil
     */
    public ResultUtil get(HttpServletRequest request) {

        //获取请求 url
        String url= RequstUtil.getRequstUrl(request,null,false);

        //rpc 统一转发 GET 请求
        return restTemplate.getForEntity(url,ResultUtil.class).getBody();
    }

    /**
     * @description 处理 post 请求逻辑
     * @author 董朱旭
     * @time 2017/11/9
     * @CopyRight 杭州微财网络科技有限公司
     * @param request
     * @return java.lang.Object
     */
    public  ResultUtil post(HttpServletRequest request) {
        //声明变量收集参数
        MultiValueMap<String,String> bodyMap = new LinkedMultiValueMap<>();
        Map<String,String> map=new HashMap<>();
        //获取请求 url
        String url= RequstUtil.getRequstUrl(request,map,true);
        bodyMap.setAll(map);
        //rpc 统一转发 POST 请求
        return restTemplate.postForEntity(url,bodyMap,ResultUtil.class).getBody();
    }
    /**
     * @description 处理 put 请求逻辑
     * @author 董朱旭
     * @time 2017/11/9
     * @CopyRight 杭州微财网络科技有限公司
     * @param request
     * @return java.lang.Object
     */
    public ResultUtil put(HttpServletRequest request) {

        //获取请求 url
        String url= RequstUtil.getRequstUrl(request,null,false);

        //rpc 统一转发 PUT 请求
        return restTemplate.exchange(url, HttpMethod.PUT, null, ResultUtil.class).getBody();
    }


    /**
     * @description 处理 delete 请求逻辑
     * @author 董朱旭
     * @time 2017/11/9
     * @CopyRight 杭州微财网络科技有限公司
     * @param request
     * @return java.lang.Object
     */
    public ResultUtil delete(HttpServletRequest request) {
        //获取请求 url
        String url= RequstUtil.getRequstUrl(request,null,false);

        //rpc 统一转发 DELETE 请求
        return restTemplate.exchange(url, HttpMethod.DELETE, null, ResultUtil.class).getBody();
    }
}