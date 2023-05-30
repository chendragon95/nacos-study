package com.chenlongji.nacosstudy.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author clj
 */
@RestController
@RequestMapping("/springCloud")
public class SpringCloudController {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 使用该方式, 不使用@EnableDiscoveryClient都可以
     * http://localhost:8033/springCloud/sendMsg?name=lisi
     * http://localhost:8033/springCloud/sendMsg?name=zhangsan
     */
    @GetMapping("/sendMsg")
    public String sendMsg(@RequestParam(name = "name") String name){
        String phone = restTemplate.getForObject("http://user-service/getUserPhone?name=" + name, String.class);
        return String.format("发送短信给[%s], 手机号为[%s]", name, phone);
    }

}