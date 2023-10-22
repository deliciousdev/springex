package com.example.springex.controller.request;


import lombok.Data;
import lombok.Getter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
public class ArticleModifyRequest {


    private int articleId;
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    private String writer;
    private int writerId;
}
