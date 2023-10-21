package com.example.springex.service;


import com.example.springex.domain.dto.ArticleDto;
import com.example.springex.domain.entity.Article;

import java.util.List;

public interface ArticleService {

    int register(String article, String content);

    List<ArticleDto> getArticles();

    ArticleDto readArticle(int articleId);

    void remove(int articleId);
}
