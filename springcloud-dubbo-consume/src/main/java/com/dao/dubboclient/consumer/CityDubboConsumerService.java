package com.dao.dubboclient.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.dao.dubboclient.provider.CityDubboService;
import com.dao.dubboclient.vo.City;
import org.springframework.stereotype.Component;

/**
 * 城市 Dubbo 服务消费者
 *
 * Created by bysocket on 28/02/2017.
 */
@Component
public class CityDubboConsumerService {

    @Reference(version = "1.0.0")
    CityDubboService cityDubboService;

    public void printCity() {
        String cityName="安庆";
        City city = cityDubboService.findCityByName(cityName);
        System.out.println(city.toString());
    }
}
