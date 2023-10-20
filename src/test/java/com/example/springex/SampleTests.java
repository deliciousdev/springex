package com.example.springex;

import com.example.springex.domain.entity.Article;
import com.example.springex.mapper.ArticleMapper;
import com.example.springex.mapper.TimeMapper2;
import com.example.springex.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {


    @Autowired
    DataSource dataSource;

    @Autowired(required = false)
    ArticleMapper articleMapper;

    @Autowired(required = false)
    TimeMapper2 timeMapper2;

    @Autowired
    ArticleService articleService;

    @Test
    void timeTest() {
        log.info(articleMapper.getTime());
    }


    @Test
//    @Transactional
    void testInsert() {
        for(int i=0; i<20; ++i){
            Article article = Article.of("title", "content");
            articleMapper.insert(article);
        }

    }

    @Test
    void selectById() {
        Article article = articleMapper.selectById(3);
        log.info("{}", article);
    }

    @Test
    void selectAll() {
        List<Article> articles = articleMapper.selectAll();
        articles.forEach(article -> log.info("{}", article));
    }

    @Test
    void deleteById() {
        articleMapper.deleteById(4);
    }

}
