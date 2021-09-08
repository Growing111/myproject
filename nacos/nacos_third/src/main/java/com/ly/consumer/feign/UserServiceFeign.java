package com.ly.consumer.feign;


import com.ly.consumer.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yuan
 */
@FeignClient("nacos-first-provice")
@Component
public interface UserServiceFeign {

    @RequestMapping(value = "/getUserInfo")
    User getUserInfo(String userId);
}
