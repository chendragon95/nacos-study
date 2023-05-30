/* Refer to document: https://github.com/alibaba/nacos/blob/master/example/src/main/java/com/alibaba/nacos/example
*  pom.xml
    <dependency>
        <groupId>com.alibaba.nacos</groupId>
        <artifactId>nacos-client</artifactId>
        <version>${latest.version}</version>
    </dependency>
*/
package com.chenlongji.nacosstudy.message.controller;

import java.util.Properties;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.listener.NamingEvent;

/**
 * @author nkorange
 */
public class JavaController {

    /**
     * 仅演示注册服务
     */
    public static void main(String[] args) throws NacosException {

        Properties properties = new Properties();
        properties.setProperty("serverAddr", "localhost:8848");
        properties.setProperty("namespace", "013f54f2-582f-4921-a998-46fdabeb0542");

        NamingService naming = NamingFactory.createNamingService(properties);

        naming.registerInstance("user-service", "11.11.11.11", 8888, "TEST1");

        naming.registerInstance("user-service", "2.2.2.2", 9999, "DEFAULT");

        System.out.println(naming.getAllInstances("user-service"));

        naming.deregisterInstance("user-service", "2.2.2.2", 9999, "DEFAULT");

        System.out.println(naming.getAllInstances("user-service"));

        naming.subscribe("user-service", new EventListener() {
            @Override
            public void onEvent(Event event) {
                System.out.println(((NamingEvent)event).getServiceName());
                System.out.println(((NamingEvent)event).getInstances());
            }
        });
    }
}