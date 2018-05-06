package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "administration")
public class AdministrationController {

  @RequestMapping("/users")
  public String getDemoPage(){
    return "administration/users";
  }

}
