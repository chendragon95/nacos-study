package com.chenlongji.nacosstudy.message.controller;

import com.chenlongji.nacosstudy.message.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clj
 */
@RestController
@RequestMapping("/")
public class FeignController {
    @Autowired
    private UserClient userClient;

    /**
     * http://localhost:8033/sendMsg?name=lisi
     * http://localhost:8033/sendMsg?name=zhangsan
     */
    @GetMapping("/sendMsg")
    public String sendMsg(@RequestParam(name = "name") String name){
        String phone = userClient.getUserPhone(name);
        return String.format("发送短信给[%s], 手机号为[%s]", name, phone);
    }

}