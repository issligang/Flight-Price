package com.haina.flight.price;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes={FlightApplication.class})
public class RedisTest {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void test(){
        System.out.println(redisTemplate.opsForValue().get("qq123"));
        //redisTemplate.opsForValue().set("qq123", "aaa");
    }




}
