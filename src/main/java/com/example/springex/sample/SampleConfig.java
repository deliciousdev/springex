package com.example.springex.sample;

import com.example.springex.sample.reposoitory.SampleRepository;
import com.example.springex.sample.reposoitory.SampleRepositoryImpl;
import com.example.springex.sample.service.SampleService;
import com.example.springex.sample.service.SampleServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
//@Component
public class SampleConfig {

    @Bean
    public SampleService sampleService() {
        return new SampleServiceImpl(sampleRepository());
    }

    @Bean
    public SampleRepository sampleRepository(){
        return new SampleRepositoryImpl();
    }

}
