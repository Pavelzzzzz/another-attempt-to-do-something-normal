package com.eva.another_attempt_to_do_something_normal.controller;

import com.eva.another_attempt_to_do_something_normal.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class MainController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/news/{id}")
    public String getNews(@PathVariable("id") int id, Model model){
        model.addAttribute("news",
            newsService.getNewsByNewsIdAndLanguageId(id, 1));
        return "news";
    }

}
