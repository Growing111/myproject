package com.ly.naocs.controller;

import com.ly.naocs.entity.User;
import com.ly.naocs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yuan
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user")
    public String test() {
        return "this is first provider";
    }

    @RequestMapping(value = "/getUserInfo")
    public User getUserInfo() {
        return userService.getUserInfo("00A");
    }

}
