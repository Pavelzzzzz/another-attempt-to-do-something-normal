package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLCategoryEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.CategoryService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "api/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @GetMapping
  public ResponseEntity<?> findAllCategories(
      @QuerydslPredicate(root = TblAPLCategoryEntity.class) Predicate predicate, Pageable pageable) {
    return ResponseEntity.ok(categoryService.findAll(predicate, pageable));
  }

  @PostMapping
  public ResponseEntity<?> addCategory(
      @RequestParam String categoryName){
    Category newCategory = new Category();
    newCategory.setCategoryName(categoryName);
    int categoryId = categoryService.save(newCategory);
    return new ResponseEntity<Integer>(categoryId, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteCategory(
      @PathVariable("id") int id){
        categoryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
  }
}
