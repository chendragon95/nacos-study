package com.chenlongji.nacosstudy.live.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author clj
 */
@RestController
@RequestMapping("/springCloud")
@RefreshScope
public class SpringCloudController {

    /**
     * 使用原生注解@Value()导入配置
     */
    @Value("${user.id:1}")
    private String id;

    @Value("${user.name:1}")
    private String name;

    /**
     * 使用nacos的注解. 不建议使用, 不方便切换配置中心 (实测也没生效, 放弃)
     * @NacosValue(value = "${user.age:1}", autoRefreshed = true)
     */
    @Value(value = "${user.age:1}")
    private String age;


    /**
     * 请求路径: http://localhost:8044/springCloud/getNacosConfig
     */
    @GetMapping("getNacosConfig")
    public String providerTest() {
        return "我是provider, 已成功获取nacos配置中心的数据：(id:" + id + ",name:" + name + ",age:" + age +")";
    }


    /**
     * dataId说明:
     *  指定前缀时: ${spring.cloud.nacos.config.prefix}-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}
     *  没指定前缀时:        ${spring.application.name}-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}
     *  值说明:
     *      spring.cloud.nacos.config.prefix为指定的前缀, 不指定则使用spring.application.name
     *      spring.application.name为应用名.
     *      spring.profiles.active为激活的环境.
     *          没有配置spring.profile.active时, dataId=${spring.application.name}.${spring.cloud.nacos.config.file-extension}.
     *      file-extension为配置文件拓展名. 默认值为properties, 配置路径spring.cloud.nacos.config.file-extension.
     *          注意: springboot项目配置该值时需在bootstrap.yml或在bootstrap.properties配置才有效.
     *      旧版本时: ${spring.application.name}前还可以添加${spring.application.group}:
     *          即${spring.application.group}:${spring.application.name}-${spring.profiles.active}.${spring.cloud.nacos.config.file-extension}
     * nacos读取多个配置:
     *  https://blog.csdn.net/a745233700/article/details/122916208
     *  未亲测
     */

}
