package com.example.springex.controller;


import com.example.springex.controller.request.ArticleRegisterRequest;
import com.example.springex.domain.dto.ArticleDto;
import com.example.springex.service.ArticleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/article")
@RequiredArgsConstructor
@Slf4j
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/register-form")
    public String registerForm(){
        return "articleRegisterForm";
    }

    @GetMapping("/list")
    public String list(Model model){
        log.info("ArticleController.list");
        List<ArticleDto> articles = articleService.getArticles();
        model.addAttribute("articles", articles);
//        articles.forEach(a->log.info("{}",a));
        return "list";
    }

    @PostMapping
    public String register(
            @Valid ArticleRegisterRequest articleRegisterRequest,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes){
        log.info("ArticleController.register");

        if(bindingResult.hasErrors()){
            log.info("has errors----------------");
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/article/register-form";
        }

        articleService.register(articleRegisterRequest.getTitle(), articleRegisterRequest.getContent());
        return "redirect:/article";
    }

    @GetMapping("/read")
    public String readArticle(@RequestParam int articleId,Model model){
        ArticleDto articleDto = articleService.readArticle(articleId);
        model.addAttribute("articleDto", articleDto);
        return "article";
    }

    @GetMapping("/modify")
    public String articleModifyForm(@RequestParam int articleId,Model model){
        ArticleDto articleDto = articleService.readArticle(articleId);
        model.addAttribute("articleDto", articleDto);
        return "articleModifyForm";
    }

    @PostMapping("/remove")
    public String removeArticle( @RequestParam int articleId,RedirectAttributes redirectAttributes) {
        log.info("{}",articleId);
        articleService.remove(articleId);
        return "redirect:/article/list";
    }

}
