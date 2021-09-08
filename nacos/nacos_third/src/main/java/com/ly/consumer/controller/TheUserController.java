package com.ly.consumer.controller;


import com.ly.consumer.entity.User;
import com.ly.consumer.feign.UserServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuan
 */
@RestController
@RefreshScope
public class TheUserController {

    @Autowired
    private UserServiceFeign userServiceFegin;

    @RequestMapping(value = "/testFeign")
    public User getInfo() {
        return userServiceFegin.getUserInfo("test");
    }
}
