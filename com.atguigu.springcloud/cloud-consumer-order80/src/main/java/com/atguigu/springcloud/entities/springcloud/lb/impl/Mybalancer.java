package com.atguigu.springcloud.entities.springcloud.lb.impl;

import com.atguigu.springcloud.entities.springcloud.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class Mybalancer implements LoadBalancer {

    private final AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current>= Integer.MAX_VALUE?0:current+1;
        }while(!this.atomicInteger.compareAndSet(current,next));//第一个参数是期望值，第二个参数是是修改值
        System.out.println("第几次访问："+current);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstanceList) {
        int index = getAndIncrement()%serviceInstanceList.size();
        return serviceInstanceList.get(index);
    }
}
