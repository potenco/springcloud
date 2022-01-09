package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.OrderHystrixService;
import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements OrderHystrixService {


    @Override
    public String paymentInfo_ok(Integer id) {
        return "调用正常O(∩_∩)O哈哈~";
    }

    @Override
    public String paymentInfo_timeout_id(Integer id) {
        return "调用异常！o(╥﹏╥)o";
    }
}
