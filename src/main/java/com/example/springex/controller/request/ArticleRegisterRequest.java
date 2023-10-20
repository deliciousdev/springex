package com.example.springex.controller.request;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ArticleRegisterRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
