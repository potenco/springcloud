package com.atguigu.springcloud.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderConsulController {

    @Value("${server.port")
    private String serverPort;
    @Resource
    private RestTemplate restTemplate;


    public static final String INVOKE_URL= "http://consul-provider-payment";

    @GetMapping(value = "/consumer/payment/consul")
    public String payment(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
    }
}
