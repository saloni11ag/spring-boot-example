package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

import java.util.Arrays;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableFeignClients
@EnableHystrix
public class HystrixAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HystrixAppApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    //    @GetMapping("/get")
//    @HystrixCommand(fallbackMethod = "fallback_getItems", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "100000")
//    })
//    public String getItems() throws InterruptedException {
////        Thread.sleep(3000);
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity <String> entity = new HttpEntity<String>(headers);
//
//        return restTemplate.exchange("http://localhost:8080/getAll", HttpMethod.GET, entity, String.class).getBody();
//    }


//    private String fallback_getItems() {
//        return "Request fails. It takes long time to response";
//    }

}
