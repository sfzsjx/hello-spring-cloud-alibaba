package com.funtl.hello.spring.cloud.alibaba.nacos.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableDiscoveryClient用于表明是nacos客户端
@EnableDiscoveryClient
public class NacosProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class,args);
    }

    @Value("${server.port}")
    private String port;

    @RestController
    public class EchoController{

        @GetMapping(value = "/echo/{message}")
        public String echo(@PathVariable String message){
            //return "Hello Nacos Discovery " + message;
            return "Hello Nacos Discovery " + message  + "I am from port " + port;
        }
    }
}
