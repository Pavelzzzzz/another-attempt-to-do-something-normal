package com.eva.another_attempt_to_do_something_normal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "editor")
public class EditorController {

  @GetMapping("/news_editor")
  public String getNewsEditorPage(){
    return "editor/news_editor";
  }

  @GetMapping("/news_editor/{id}")
  public String getNewsEditorByNewsIdPage() {
    return "editor/news_editor";
  }

  @GetMapping("/categories")
  public String getCategoriesPage(){
    return "editor/categories";
  }

}
