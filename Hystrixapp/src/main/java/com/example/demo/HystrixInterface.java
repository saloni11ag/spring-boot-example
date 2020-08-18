package com.example.demo;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@FeignClient(name="item-catalog",configuration = FeignClientConfiguration.class )
public interface HystrixInterface {


    @RequestMapping("/getAll")
    public String findAll();
}
