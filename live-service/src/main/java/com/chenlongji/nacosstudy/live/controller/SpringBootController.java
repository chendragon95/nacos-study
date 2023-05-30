package com.chenlongji.nacosstudy.live.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clj
 * springBoot项目时没有@RefreshScope注解的, 无法实时刷新值
 */
@RestController
@RequestMapping("/springBoot")
public class SpringBootController {

    /**
     * 使用原生注解@Value()导入配置
     */
    @Value("${user.name:1}")
    private String name;

/*    public void setName(String name){
        this.name = name;
    }*/

    /**
     * 请求路径: http://localhost:8044/springBoot/getNacosConfig
     */
    @GetMapping("getNacosConfig")
    public String providerTest() {
        return "我是provider, 已成功获取nacos配置中心的数据：(name:" + name+")";
    }

}
