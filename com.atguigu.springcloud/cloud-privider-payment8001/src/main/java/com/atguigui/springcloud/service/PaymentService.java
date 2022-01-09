package com.atguigui.springcloud.service;


import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


@Service
public interface PaymentService {

    
    int create(Payment payment);

    Payment getPayment(@Param("id")Long id);

}
