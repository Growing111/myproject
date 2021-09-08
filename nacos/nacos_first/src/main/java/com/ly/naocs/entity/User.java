package com.ly.naocs.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan
 */
@Data
public class User implements Serializable {

    public User(Integer userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    private Integer userId;
    private String username;
    private String password;



}
