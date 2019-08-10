package com.yidu.order;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@EnableFeignClients //启用Feign
@EnableDiscoveryClient //加入Eureka注册
@SpringBootApplication
@EnableHystrix //加入容错保护
public class OrderApplication {

    //关于OkHttp与HttpClient用法差不多,但是目前OkHttp更加流行
    @Bean //向spring容器注册restTemplate对象
    @LoadBalanced //开启负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
