package com.example.demo;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RefreshScope
@RestController
public class FeignController {

    @Autowired
    HystrixInterface hystrixInterface;

    @RequestMapping("/findAll")
    @HystrixCommand(fallbackMethod = "fallback_getItems", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String getItems() {

        return hystrixInterface.findAll();

    }

    private String fallback_getItems() {
        return "Request failed.";
    }

}

