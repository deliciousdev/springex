package com.example.springex;

import com.example.springex.mapper.TimeMapper;
import com.example.springex.mapper.TimeMapper2;
import com.example.springex.sample.reposoitory.SampleRepository;
import com.example.springex.sample.service.SampleService;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Slf4j
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/root-context.xml")
public class SampleTests {

    @Autowired
    SampleService sampleService;

    @Autowired
    SampleRepository sampleRepository;

    @Autowired
    DataSource dataSource;

    @Autowired(required = false)
    TimeMapper timeMapper;

    @Autowired(required = false)
    TimeMapper2 timeMapper2;

    @Test
    void testService1() throws SQLException, InterruptedException {
        log.info("{}",sampleService);
        log.info("{}",sampleRepository);

        Connection connection = dataSource.getConnection();
        log.info("{}",connection);
        Assertions.assertNotNull(connection);
    }

    @Test
    public void timeTest(){
        log.info(timeMapper.getTime());
        log.info(timeMapper2.getNow());
    }
}
