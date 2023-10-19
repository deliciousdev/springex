package com.example.springex.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;

@Controller
@Slf4j
public class SampleController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestParam LocalDate testParam){
        log.info("{}",testParam);
        return "hello";
    }
}
