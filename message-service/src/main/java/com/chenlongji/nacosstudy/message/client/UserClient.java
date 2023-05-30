package com.chenlongji.nacosstudy.message.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author clj
 */
@FeignClient(value = "user-service")
public interface UserClient {

    @GetMapping("/getUserPhone")
    String getUserPhone(@RequestParam(name = "name") String name);

}
