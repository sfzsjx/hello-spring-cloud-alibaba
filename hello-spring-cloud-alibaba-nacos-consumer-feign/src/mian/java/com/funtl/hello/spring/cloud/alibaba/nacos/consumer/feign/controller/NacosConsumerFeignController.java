package com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.controller;


import com.funtl.hello.spring.cloud.alibaba.nacos.consumer.feign.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosConsumerFeignController {

    @Autowired
    private EchoService echoService;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @GetMapping(value = "/echo/hi")
    public String echo(){
        return echoService.echo("Hi Feign");
    }

    @GetMapping(value = "/hi")
    public String sayHi(){
        return "Hello " + applicationContext.getEnvironment().getProperty("user.name");
    }
}
