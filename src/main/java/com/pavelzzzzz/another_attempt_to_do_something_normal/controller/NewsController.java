package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.UserSecurity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.NewsService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/editor/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getNewsById(
        @PathVariable("id") int newsId,
        @RequestParam(defaultValue = "1") int languageId) {
        News news = newsService.getNewsByNewsIdAndLanguageId(
            newsId, languageId);
        return new ResponseEntity<News>(news, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addNews(
            @RequestParam int languageId,
            @RequestParam int categoryId,
            @RequestParam String title,
            @RequestParam String htmlText){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Integer userId;
        if (null == auth) {
            userId = null;
        }
        Object obj = auth.getPrincipal();
        if (obj instanceof UserSecurity) {
            userId = ((UserSecurity) obj).getUserId();
        } else {
            userId = null;
        }
        int newsId = newsService.save(languageId, categoryId, userId, title, htmlText);
        return new ResponseEntity<Integer>(newsId, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateNews(
        @RequestParam int newsId,
        @RequestParam int languageId,
        @RequestParam int categoryId,
        @RequestParam String title,
        @RequestParam String htmlText){
        newsService.update(newsId, languageId, categoryId, title, htmlText);
        return new ResponseEntity<Integer>(
            newsService.update(newsId, languageId, categoryId, title, htmlText), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(
        @PathVariable("id") int newsId) {
        newsService.delete(newsId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
