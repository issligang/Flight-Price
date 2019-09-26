package com.haina.flight.price.dao;

import com.haina.flight.price.model.FlightPrice;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface FlightPriceMapper {

    /**
     * 根据 出发-到达-出发时间 查询航班列表
     * @param origin
     * @param dest
     * @param departDate
     * @return
     */
    List<FlightPrice> selectByODAndDepartDate(@Param("origin") String origin, @Param("dest") String dest, @Param("departDate") String departDate);


}