package com.chenlongji.nacosstudy.live;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author clj
 * 说明: 本项目仅测试nacos配置中心
 */
@SpringBootApplication
public class LiveApplication {
    /**
     * nacos服务端启动脚本位置 E:\other\nacos-server-2.2.2\nacos\bin\
     * http://localhost:8848/nacos
     */
    public static void main(String[] args) {
        SpringApplication.run(LiveApplication.class, args);
    }
}
