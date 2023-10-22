package com.example.springex.controller.request;


import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
public class ArticleModifyRequest {

    private int articleId;
    private String title;
    private String content;
    private String writer;
    private int writerId;
}
