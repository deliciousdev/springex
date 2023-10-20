package com.example.springex.domain.entity;

import lombok.*;

import java.time.LocalDateTime;



@Getter
@ToString
public class Article {

    private int id;
    private String title;
    private String content;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private User user;

    private Article(String title,String content){
        this.title= title;
        this.content = content;
    }

    public static Article of(String title,String content){
        return new Article(title, content);
    }



}
