package com.haina.flight.price.controller;

import com.haina.flight.price.constants.Constants;
import com.haina.flight.price.dao.FlightPriceMapper;
import com.haina.flight.price.model.FlightPrice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping(produces = "application/json;charset=UTF-8")
public class TestController {

    @Resource
    private FlightPriceMapper flightPriceMapper;

    @RequestMapping("getFlight")
    public List<FlightPrice> getFlight(){
        return flightPriceMapper.selectByODAndDepartDate("BJS", "BKK", "2019-05-20");
    }

    @RequestMapping("getValue")
    public int getValue(){
        return Constants.abc;
    }

}
