package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "editor")
public class EditorController {

  @RequestMapping("/news_editor")
  public String getDemoPage(){
    return "editor/news_editor";
  }

  @RequestMapping("/categories")
  public String getCategoriesPage(){
    return "editor/categories";
  }

}
