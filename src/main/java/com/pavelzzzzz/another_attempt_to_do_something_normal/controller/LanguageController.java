package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSERLanguageEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.LanguageService;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "api/administration/languages")
public class LanguageController {

  @Autowired
  private LanguageService languageService;

  @GetMapping
  public ResponseEntity<?> findAllLanguages(
      @QuerydslPredicate(root = TblSERLanguageEntity.class) Predicate predicate, Pageable pageable) {
    return ResponseEntity.ok(languageService.findAll(predicate, pageable));
  }
}
