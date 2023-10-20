package com.example.springex.domain.entity;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class User {

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private int id;
    private String username;
    private String password;

}
