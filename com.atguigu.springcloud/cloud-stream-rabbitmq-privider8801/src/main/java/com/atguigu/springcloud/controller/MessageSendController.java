package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.message.IMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageSendController {


    @Resource
    private IMessage iMessage;

    @GetMapping("/sendMsg")
    public String sendMsg(){
        iMessage.send();
        return "SUCCESS!";
    }
}
