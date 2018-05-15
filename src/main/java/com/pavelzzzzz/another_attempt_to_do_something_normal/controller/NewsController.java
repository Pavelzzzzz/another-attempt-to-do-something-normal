package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLNewsEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.NewsService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.News;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/administration/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    @GetMapping("")
    public ResponseEntity<?> findAllNews(
            @QuerydslPredicate(root = TblAPLNewsEntity.class) Predicate predicate, Pageable pageable) {
        return ResponseEntity.ok(newsService.findAll(predicate, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNewsById(
            @PathVariable("id") int newsId,
            @RequestParam int languageId) {
        News news = newsService.getNewsByNewsIdAndLanguageId(
                newsId, languageId);
        return new ResponseEntity<News>(news, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addNews(
            @RequestParam int languageId,
            @RequestParam int categoryId,
            @RequestParam int userId,
            @RequestParam String title,
            @RequestParam String htmlText){
        int newsId = newsService.saveNews(languageId, categoryId, userId, title, htmlText);
        return new ResponseEntity<Integer>(newsId, HttpStatus.OK);
    }
}
