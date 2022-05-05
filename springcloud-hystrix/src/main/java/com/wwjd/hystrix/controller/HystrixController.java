package com.wwjd.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liugui
 * @version V1.0
 * @Package com.wwjd.hystrix.controller
 * @date 2022/5/5 21:31
 * @Copyright © 上海卓繁
 */
@RestController
public class HystrixController {

    // 默认情况下调用接口能够触发Hystrix服务降级处理的超时时间是1000ms
    @RequestMapping(value = "/get/{id}")
    @HystrixCommand(fallbackMethod = "MyErrorMeth")
    public String get(@PathVariable String id) {
        try{
            System.out.println("进入get方法before");
            Thread.sleep(1000*5);
            System.out.println("进入get方法after");
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    //Hystrix默认超时时间为1s,这里我们设置为6s。程序正常返回，不会执行fallbackMethod
    @RequestMapping(value = "/get2/{id}")
    @HystrixCommand(fallbackMethod = "MyErrorMeth",commandProperties={
            @HystrixProperty(name= HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_TIMEOUT_IN_MILLISECONDS,value="6000")
    })
    public String get2(@PathVariable String id) {
        try{
            System.out.println("进入get2方法before");
            Thread.sleep(1000*5);
            System.out.println("进入get2方法after");
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    //将隔离策略调整为信号量策略，观察同步、异步情况,信号量策略是一个同步的执行过程。
    @RequestMapping(value = "/get3/{id}")
    @HystrixCommand(fallbackMethod = "MyErrorMeth",commandProperties={
            @HystrixProperty(name= HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY,value="SEMAPHORE")
    })
    public String get3(@PathVariable String id) {
        try{
            System.out.println("进入get3方法before");
            Thread.sleep(1000*5);
            System.out.println("进入get3方法after");
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    // 设置超时的时候不中断线程,默认为true
    @RequestMapping(value = "/get4/{id}")
    @HystrixCommand(fallbackMethod = "MyErrorMeth",commandProperties={
            @HystrixProperty(name= HystrixPropertiesManager.EXECUTION_ISOLATION_THREAD_INTERRUPT_ON_TIMEOUT,value="false")
    })
    public String get4(@PathVariable String id) {
        try{
            System.out.println("进入get4方法before");
            Thread.sleep(1000*5);
            System.out.println("进入get4方法after");
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    // 设置信号量的最大请求个数。默认是10
    @RequestMapping(value = "/get5/{id}")
    @HystrixCommand(fallbackMethod = "MyErrorMeth",commandProperties={
            @HystrixProperty(name= HystrixPropertiesManager.EXECUTION_ISOLATION_STRATEGY,value="SEMAPHORE"),
            @HystrixProperty(name=HystrixPropertiesManager.EXECUTION_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS,value ="1")
    })
    public String get5(@PathVariable String id) {
        try{
            System.out.println("进入get5方法before");
            Thread.sleep(1000*5);
            System.out.println("进入get5方法after");
        }catch (Exception e){
            e.printStackTrace();
        }
        return id;
    }

    private String MyErrorMeth(String id){
        System.out.println("进入MyErrorMeth方法before");
        System.out.println("进入MyErrorMeth方法after");
        return "请求超时，方法错误，断路器返回："+id;
    }


}
