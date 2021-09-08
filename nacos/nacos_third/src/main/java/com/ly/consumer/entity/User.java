package com.ly.consumer.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author yuan
 */
@Data
public class User implements Serializable {
    private Integer userId;
    private String username;
    private String password;


}
