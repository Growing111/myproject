package com.ly.naocs.service;

import com.ly.naocs.entity.User;

/**
 * @author yuan
 */
public interface UserService {

    /**
     * @param userId     
     * @return
     */
    User getUserInfo(String userId);
}
