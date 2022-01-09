package com.atguigu.springcloud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {

    @Value("server.port")
    private String serverPort;


    @GetMapping("/testA")
    public String testA(){
//        try {
//            TimeUnit.MILLISECONDS.sleep(800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "===>TEST_A";
    }

    @GetMapping("/testB")
    public String testB(){
        return "===>TEST_B";
    }

    @GetMapping("/testRT")
    public String testRT(){
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "===>testRT";
    }

    @GetMapping("/hotKey")
    @SentinelResource(value = "hotKey",blockHandler="blockHandler")
    public String hotKey(@RequestParam(value = "p1",required = false)String p1,
                         @RequestParam(value = "p2",required = false)String p2){
        return "===>hotKey";
    }

    public String blockHandler(String p1, String p2, BlockException blockException){
        return "=========blockHandler";

    }
}
