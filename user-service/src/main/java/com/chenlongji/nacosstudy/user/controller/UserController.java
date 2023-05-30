package com.chenlongji.nacosstudy.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clj
 */
@RestController
@RequestMapping("/")
public class UserController {

    @GetMapping("/getUserPhone")
    public String getUserPhone(@RequestParam(name = "name") String name){
        switch (name) {
            case "zhangsan": return "18888888888";
            case "lisi": return "12222222222";
            default: break;
        }
        return "10000000000";
    }

}
