package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLNewsEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.NewsHeaderService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/news/headers")
public class NewsHeaderController {
    @Autowired
    private NewsHeaderService newsHeaderService;

    @GetMapping
    public ResponseEntity<?> findAllNewsHeaders(
            @QuerydslPredicate(root = TblAPLNewsEntity.class) Predicate predicate, Pageable pageable) {
        return ResponseEntity.ok(newsHeaderService.findAll(predicate, pageable, 1));
    }
}
