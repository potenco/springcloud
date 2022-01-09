package springcloud.controller;


import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import springcloud.service.PaymentService;

import javax.annotation.Resource;


@Slf4j
@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("插入结果: " + result);
        if (result > 0) {
            return new CommonResult(200, "插入数据库成功,端口号为：" + serverPort, result);
        } else {
            return new CommonResult(444, "插入数据库失败！端口号为：" + serverPort, null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPayment(id);
        log.info("查询结果是:" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功，端口号为：" + serverPort, payment);
        } else {
            return new CommonResult(444, "没有对应记录，端口号为：" + serverPort, null);
        }
    }

    @GetMapping("/payment/lb")
    public String getServerPort(){
        return serverPort;
    }
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return serverPort;
    }
}
