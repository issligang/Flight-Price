package com.haina.flight.price.feign;

import com.google.common.collect.Lists;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = Lists.newArrayList("a", "b", "c", "d", "e");
        list.stream().filter(str -> str != "c").forEach(System.out::println);
        List<Integer> l1 = Lists.newArrayList(1,2,3,4,5);
        l1.stream().map(i -> i+1).forEach(System.out::println);

    }

}
