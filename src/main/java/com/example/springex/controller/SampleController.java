package com.example.springex.controller;


import com.example.springex.domain.dto.TestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    //http://localhost:8080/test2?stringParam=abccc&intParam=11&localDateParam=2020-10-10&booleanParam=false
    @RequestMapping("/test2")
    @ResponseBody
    public String test2(TestDto testDto) {//@RequestParam 붙이면 안됨.
        log.info("{}", testDto);
        return "hello2";
    }

    @GetMapping("/testForm")
    public String testForm(){
        return "test";
    }

    @GetMapping("/redirectTest")
    public String redirectTest(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("param","pasdfsadf");
        return "redirect:redirectResult";
    }

    @GetMapping("/redirectResult")
    @ResponseBody
    public String redirectResult(){
        return "redirect success";
    }

    @GetMapping("/redirectTest2")
    public String redirectTest2(RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("papa","ahahahahah");
        redirectAttributes.addFlashAttribute("flashParam", "qwerqwer");
        return "redirect:redirectResult2";
    }

    @GetMapping("/redirectResult2")
    public String redirectResult2(){
        return "redirectTest";
    }
}
