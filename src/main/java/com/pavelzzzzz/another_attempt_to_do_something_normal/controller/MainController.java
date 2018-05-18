package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import com.pavelzzzzz.another_attempt_to_do_something_normal.security.UserValidator;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.UserSecurity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.impl.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserSecurityService userSecurityService;

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                           @RequestParam(value = "logout", required = false) String logout,
                           Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistrationPage(Model model) {
        model.addAttribute("userForm", new UserSecurity());
        return "registration";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") UserSecurity userForm,
        BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userSecurityService.save(userForm);

        return "redirect:/";
    }
}
