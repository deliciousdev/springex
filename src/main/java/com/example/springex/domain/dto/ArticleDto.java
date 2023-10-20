package com.example.springex.domain.dto;


import com.example.springex.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@Getter
@ToString
public class ArticleDto {

    private int id;
    private UserDto userDto;
    private String title;
    private String content;

    private String createdAt;
    private String updatedAt;

    public static ArticleDto fromEntity(Article article){
        return new ArticleDto(
                article.getId(),
                UserDto.fromEntity(article.getUser()),
                article.getTitle(),
                article.getContent(),
                article.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")),
                article.getUpdatedAt().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                ));
    }

}
