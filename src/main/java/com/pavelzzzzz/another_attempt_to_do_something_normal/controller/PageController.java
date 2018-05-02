package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "administration/users")
public class PageController {

  @RequestMapping("")
  public String getDemoPage(){
    return "administration/users";
  }

}
