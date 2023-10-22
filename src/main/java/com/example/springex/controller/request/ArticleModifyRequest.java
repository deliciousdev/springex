package com.example.springex.controller.request;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Data
@ToString
@NoArgsConstructor
public class ArticleModifyRequest {


    private int articleId;
    @NotBlank
    private String title;
    @NotBlank
    private String content;

    private String writer;
    private int writerId;
}
