package com.haina.flight.price.service;

import com.haina.flight.price.model.FlightPrice;

import java.util.List;

/**
 * 航班查询service
 */
public interface FlightService {

    /**
     * 通过 出发-到达-出发时间 查询航班数据
     * @param origin
     * @param dest
     * @param departDate
     * @return
     */
    List<FlightPrice> getFlightByODAndDate(String origin, String dest, String departDate);

}
