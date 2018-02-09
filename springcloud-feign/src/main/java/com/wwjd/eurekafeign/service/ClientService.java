package com.wwjd.eurekafeign.service;

import com.wwjd.eurekafeign.util.PutBody;
import com.wwjd.eurekafeign.util.ResultUtil;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author 董朱旭
 * @version BUILD1001
 * @fileName com.wwjd.eurekafeign.service.ClientService.java
 * @CopyRright (c) 2017-bxm：杭州微财科技有限公司
 * @created 2017-11-09 15:54:00
 * @modifier 董朱旭
 * @updated 2017-11-09 15:54:00
 * @description
 */
@FeignClient(name="client")
public interface ClientService {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    ResultUtil<String> higet(@RequestParam(value = "time") String time);

    @RequestMapping(value = "/hi",method = RequestMethod.POST)
    ResultUtil<String> hipost(@RequestBody PutBody putBody);

    @RequestMapping(value = "/hi",method = RequestMethod.PUT)
    ResultUtil<String> hiput(@RequestBody PutBody putBody);
    @RequestMapping(value = "/hi",method = RequestMethod.DELETE)
    ResultUtil<String> hidelete(@RequestParam(value = "time") String time);
}
