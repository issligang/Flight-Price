package com.haina.flight.price.service;

import com.haina.flight.price.model.Flight;
import com.haina.flight.price.model.FlightRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

//参数是远程服务的服务名，fegin通过该参数，去注册中心获取机器信息
@FeignClient("fegin-flight-service")
public interface FeignFlightService {

    //feign获取到机器信息后，通过mapping里的value，去远程服务，调用该接口
    @RequestMapping(value = "getFlightByODAndDate", method = RequestMethod.POST)
    List<Flight> getFlightByODAndDepartDate(FlightRequest request);


}