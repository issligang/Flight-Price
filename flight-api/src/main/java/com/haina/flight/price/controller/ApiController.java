package com.haina.flight.price.controller;

import com.haina.flight.price.model.Flight;
import com.haina.flight.price.model.FlightRequest;
import com.haina.flight.price.response.FlightResult;
import com.haina.flight.price.service.FeignFlightService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class ApiController {

    @Resource
    private FeignFlightService feignFlightService;

    @RequestMapping("getFlight")
    public FlightResult getFlight(String origin, String dest, String departDate){
        FlightRequest request = new FlightRequest();
        request.setOrigin(origin);
        request.setDest(dest);
        request.setDepartDate(departDate);
        try{
            List<Flight> list = feignFlightService.getFlightByODAndDepartDate(request);
            return FlightResult.success(list);
        } catch (Exception e) {
            return FlightResult.fail();
        }
    }

}
