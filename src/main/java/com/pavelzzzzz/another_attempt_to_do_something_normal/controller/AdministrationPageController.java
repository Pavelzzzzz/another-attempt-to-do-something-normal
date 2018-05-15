package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "administration")
public class AdministrationPageController {

  @RequestMapping("/users")
  public String getUsersPage(){
    return "administration/users";
  }

  @RequestMapping("/categories")
  public String getCategoriesPage(){
    return "administration/categories";
  }

}
