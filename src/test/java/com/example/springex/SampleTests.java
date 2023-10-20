package com.example.springex;

import com.example.springex.mapper.ArticleMapper;
import com.example.springex.mapper.TimeMapper2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

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

    @Test
    public void timeTest(){
        log.info(articleMapper.getTime());
    }
}
