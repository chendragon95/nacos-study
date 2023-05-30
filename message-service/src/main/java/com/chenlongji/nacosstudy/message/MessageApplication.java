package com.chenlongji.nacosstudy.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author clj
 */
@SpringBootApplication
// 开启服务注册和发现 spring-cloud-commons包下的注解
@EnableDiscoveryClient
// 开启feign
@EnableFeignClients
public class MessageApplication {

    /**
     * nacos服务端启动脚本位置 E:\other\nacos-server-2.2.2\nacos\bin\
     * http://localhost:8848/nacos
     */
    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }
}
