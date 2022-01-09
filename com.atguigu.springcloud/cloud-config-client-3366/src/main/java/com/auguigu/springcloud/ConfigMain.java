package com.auguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ConfigMain {
    public static void main(String[] args) {
        SpringApplication.run(ConfigMain.class,args);
    }
}
