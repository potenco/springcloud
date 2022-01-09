package com.atguigu.springcloud.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGateWayContextConfig {


    @Bean
    public RouteLocator customRoutorLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_rote_atguigu1",r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();

    }
    @Bean
    public RouteLocator customRoutorLocator2(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_rote_atguigu2",r->r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
        return routes.build();

    }

}
