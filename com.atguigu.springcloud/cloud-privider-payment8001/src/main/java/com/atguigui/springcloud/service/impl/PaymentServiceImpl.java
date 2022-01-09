package com.atguigui.springcloud.service.impl;


import com.atguigu.springcloud.entities.Payment;
import com.atguigui.springcloud.dao.PaymentDao;
import com.atguigui.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPayment(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
