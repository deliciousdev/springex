package com.example.springex.service;


import com.example.springex.domain.dto.ArticleDto;
import com.example.springex.domain.entity.Article;
import com.example.springex.mapper.ArticleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Service
@RequiredArgsConstructor
public class ArticleServiceIml implements ArticleService {

    private final ArticleMapper articleMapper;

    @Override
    public int register(String title, String content) {
        Article article = Article.of(title, content);
        articleMapper.insert(article);
        return article.getId();
    }

    @Override
    public List<ArticleDto> getArticles() {
        List<Article> articles = articleMapper.selectAll();
        return articles.stream().map(ArticleDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public ArticleDto readArticle(int articleId) {
        Article article = articleMapper.selectById(articleId);
        return ArticleDto.fromEntity(article);
    }

    @Override
    public void remove(int articleId) {
        articleMapper.deleteById(articleId);
    }

    @Override
    public ArticleDto modify(int articleId,String newTitle, String newContent) {
        Article article = articleMapper.selectById(articleId);
        article.update(newTitle,newContent);
        articleMapper.update(article);
        return ArticleDto.fromEntity(article);
    }


}
