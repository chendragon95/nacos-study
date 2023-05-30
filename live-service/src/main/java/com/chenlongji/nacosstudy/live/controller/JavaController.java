package com.chenlongji.nacosstudy.live.controller;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.PropertyKeyConst;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.ConfigType;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * @author clj
 */
public class JavaController {
    public static void main(String[] args) throws NacosException, InterruptedException {
        String serverAddr = "localhost";
        String dataId = "live-service.yml";
        String group = "DEFAULT_GROUP";
        Properties properties = new Properties();
        properties.put(PropertyKeyConst.SERVER_ADDR, serverAddr);
        ConfigService configService = NacosFactory.createConfigService(properties);
        String content = configService.getConfig(dataId, group, 5000);
        // 打印
        System.out.println(content);

        configService.addListener(dataId, group, new Listener() {
            @Override
            public void receiveConfigInfo(String configInfo) {
                System.out.println("recieve:" + configInfo);
            }

            @Override
            public Executor getExecutor() {
                return null;
            }
        });

        //boolean isPublishOk = configService.publishConfig(dataId, group, "content");

        boolean isPublishOk = configService.publishConfig(dataId, group, "user:\n" +
                "  id: 666\n" +
                "  name: chenlongji\n" +
                "  age: 11", ConfigType.YAML.getType());
        System.out.println(isPublishOk);

        Thread.sleep(3000);
        /*content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);

        boolean isRemoveOk = configService.removeConfig(dataId, group);
        System.out.println(isRemoveOk);
        Thread.sleep(3000);*/

        content = configService.getConfig(dataId, group, 5000);
        System.out.println(content);



        Thread.sleep(300000);

    }
}
