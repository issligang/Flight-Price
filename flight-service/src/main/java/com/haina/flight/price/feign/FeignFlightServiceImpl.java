package com.haina.flight.price.feign;

import com.haina.flight.price.constants.CarrierEnum;
import com.haina.flight.price.model.Flight;
import com.haina.flight.price.model.FlightPrice;
import com.haina.flight.price.model.FlightRequest;
import com.haina.flight.price.service.FeignFlightService;
import com.haina.flight.price.service.FlightService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FeignFlightServiceImpl implements FeignFlightService {

    @Resource
    private FlightService flightService;

    @Override
    public List<Flight> getFlightByODAndDepartDate(@RequestBody FlightRequest request) {
        //调用 flightService 获取数据
        //把FlightPrice类型数据，转换为flight类型
        List<FlightPrice> flightPriceList = flightService.getFlightByODAndDate(request.getOrigin(), request.getDest(), request.getDepartDate());
        //list转换成stream，然后每个元素都会调用map里面的方法，执行类型转换逻辑
        //最后把转换后的结果，收集成list集合类型

        //flightPriceList.stream().map(flightPrice -> convertFlightPirce(flightPrice)).collect(Collectors.toList());

        return flightPriceList.stream().map(this::convertFlightPirce).collect(Collectors.toList());
    }

    //类型转换，把flightPrice类型转换成flight类型
    private Flight convertFlightPirce(FlightPrice flightPrice) {
        Flight result = new Flight();
        result.setId(flightPrice.getId());
        result.setOrigin(flightPrice.getOrigin());
        result.setDest(flightPrice.getDest());
        result.setBaggage(flightPrice.getBaggage());
        result.setRule(flightPrice.getRule());
        result.setDepartDate(flightPrice.getDepartDate());
        result.setDepartTime(flightPrice.getDepartTime());
        result.setArrivalDate(flightPrice.getArrivalDate());
        result.setArrivalTime(flightPrice.getArrivalTime());
        result.setCarrier(flightPrice.getCarrier());
        result.setFlightNo(flightPrice.getFlightNo());
        result.setAircraft(flightPrice.getAircraft());
        result.setActFlightNo(flightPrice.getActFlightNo());
        result.setActCarrier(flightPrice.getActCarrier());
        result.setPrice(flightPrice.getPrice());
        result.setCarrierName(CarrierEnum.getNameBuCarrier(flightPrice.getCarrier()));
        return result;
    }
}
