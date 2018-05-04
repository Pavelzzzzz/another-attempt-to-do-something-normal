package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLCategoryEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "api/administration/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @GetMapping("")
  public ResponseEntity<?> getAllCategories(
      @QuerydslPredicate(root = TblAPLCategoryEntity.class) Predicate predicate, Pageable pageable) {
    return ResponseEntity.ok(categoryService.getAllCategories(predicate, pageable));
  }
}
