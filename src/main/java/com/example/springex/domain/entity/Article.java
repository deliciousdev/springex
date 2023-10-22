package com.example.springex.domain.entity;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;


@Getter
@ToString
public class Article {

    @Setter
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

    public void update(String newTitle,String newContent){
        this.title = newTitle;
        this.content = newContent;
    }

}
