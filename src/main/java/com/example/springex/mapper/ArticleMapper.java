package com.example.springex.mapper;

import com.example.springex.domain.dto.ArticleDto;
import com.example.springex.domain.entity.Article;

import java.util.List;

public interface ArticleMapper {

    String getTime(); //mapper.xml 에서 id와 일치해야함

    void insert(Article article);

    List<Article> selectAll();

    Article selectById(int id);

    void deleteById(int id);

    void update(Article article);
}
