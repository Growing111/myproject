package com.ly.naocs.service.imp;

import com.ly.naocs.entity.User;
import com.ly.naocs.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {

    @Override
    public User getUserInfo(String userId) {
        return new User(001,"张三");
    }
}
