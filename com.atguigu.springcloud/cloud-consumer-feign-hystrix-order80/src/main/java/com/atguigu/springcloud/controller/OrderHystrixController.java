package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback="defaultFallBack")
public class OrderHystrixController {

    @Resource
    private OrderHystrixService orderHystrixService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
//    @HystrixCommand //开启的话会走全局默认异常处理，关闭的话走接口异常处理逻辑
    public String paymentInfo_ok_id(@PathVariable("id")Integer id){
        String result = orderHystrixService.paymentInfo_ok(id);
        log.info("result>>>>>"+result);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "4000")
//    })
    @HystrixCommand
    public String paymentInfo_timeout_id(@PathVariable("id")Integer id){
        String result = orderHystrixService.paymentInfo_timeout_id(id);
        log.info("result>>>>>"+result);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id")Integer id){
        return "我是消费者，对方支付系统繁忙，请10s钟后再试或者自己运行出错请检查自己o(╥﹏╥)o";
    }

    //下面是全局fallback
    public String defaultFallBack(){
        return "我是默认异常处理！";
    }


}
