package com.example.springex.sample.service;


import com.example.springex.sample.reposoitory.SampleRepository;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@ToString
@Service
public class SampleServiceImpl implements SampleService {

    private final SampleRepository sampleRepository;
}
