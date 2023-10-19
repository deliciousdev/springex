package com.example.springex.sample.reposoitory;


import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;


@Repository
@RequiredArgsConstructor
@Primary
public class SampleRepositoryImpl implements SampleRepository{

}
