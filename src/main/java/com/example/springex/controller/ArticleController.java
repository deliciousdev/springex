package com.example.springex.controller;


import com.example.springex.controller.request.ArticleModifyRequest;
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

    @PostMapping("/register")//등록
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

        int articleId=articleService.register(articleRegisterRequest.getTitle(), articleRegisterRequest.getContent());
        redirectAttributes.addAttribute("articleId", articleId);
        return "redirect:/article/read";
    }

    @GetMapping("/read")//읽기
    public String readArticle(@RequestParam int articleId,Model model){
        ArticleDto articleDto = articleService.readArticle(articleId);
        model.addAttribute("articleDto", articleDto);
        return "article";
    }

    @GetMapping("/modify")//수정폼
    public String articleModifyForm(@RequestParam int articleId,Model model){
        ArticleDto articleDto = articleService.readArticle(articleId);
        model.addAttribute("articleDto", articleDto);
        return "articleModifyForm";
    }

    @PostMapping("/remove")//삭제요청
    public String removeArticle( @RequestParam int articleId,RedirectAttributes redirectAttributes) {
        log.info("{}",articleId);
        articleService.remove(articleId);
        return "redirect:/article/list";
    }

    @PostMapping("/modify")//수정요청
    public String modifyArticle(ArticleModifyRequest request, RedirectAttributes redirectAttributes){
        log.info("asffadsfadsdfasdsafdsa");
        log.info("{}",request);

        ArticleDto articleDto = articleService.modify(request.getArticleId(), request.getTitle(), request.getContent());
        redirectAttributes.addFlashAttribute("articleDto", articleDto);
        redirectAttributes.addAttribute("articleId", articleDto.getId());
        return "redirect:/article/read";
    }

    @PostMapping("/booleanTest")
    @ResponseBody
    public String test(Boolean b){
        log.info("{}", b);
        return "ok";
    }
}
