package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import com.pavelzzzzz.another_attempt_to_do_something_normal.service.NewsService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "api/administration/news")
public class NewsController {

//  @Autowired
//  private NewsService newsService;
//
//    @GetMapping("/{id}")
//    public ResponseEntity<?> getNewsById(
//        @PathVariable("id") Integer newsId,
//        @RequestBody Integer languageId) {
//        News news = newsService.getNewsByLanguageIdAndNewsId(
//            languageId, newsId);
//        return new ResponseEntity<News>(news, HttpStatus.OK);
//    }
}
