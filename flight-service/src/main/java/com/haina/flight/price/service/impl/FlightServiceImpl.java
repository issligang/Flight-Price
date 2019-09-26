package com.haina.flight.price.service.impl;

import com.google.common.base.Joiner;
import com.haina.flight.price.dao.FlightPriceMapper;
import com.haina.flight.price.manager.ICacheManager;
import com.haina.flight.price.model.FlightPrice;
import com.haina.flight.price.service.FlightService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ExecutionException;


@Service
public class FlightServiceImpl implements FlightService {

    @Resource
    private FlightPriceMapper flightPriceMapper;

    @Resource
    private ICacheManager cacheManager;



    @Override
    public List<FlightPrice> getFlightByODAndDate(String origin, String dest, String departDate) {
        // redis.get(origin-dest-departDate)
        String key = generateKey(origin, dest, departDate);
        List<FlightPrice> cacheData = null;
        try {
            cacheData = cacheManager.getFromCache(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if(CollectionUtils.isNotEmpty(cacheData)){
            return cacheData;
        }

        // redis.set(origin-dest-departDate, list)
        List<FlightPrice> dbData = flightPriceMapper.selectByODAndDepartDate(origin, dest, departDate);
        if(CollectionUtils.isNotEmpty(dbData)){
            System.out.println("read from db, and save to cache");
            cacheManager.saveToCache(key, dbData);
        }
        return dbData;
    }

    /**
     * 根据 出发-到达-出发时间 生成缓存Key
     * BJS-BKK-2019-05-20
     * @param origin
     * @param dest
     * @param departDate
     * @return
     */
    private String generateKey(String origin, String dest, String departDate ) {
        return Joiner.on("-").join(origin, dest, departDate);
    }
}
