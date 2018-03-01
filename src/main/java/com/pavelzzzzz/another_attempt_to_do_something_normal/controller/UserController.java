package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import com.pavelzzzzz.another_attempt_to_do_something_normal.entity.UserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path="/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Integer id) {
        UserEntity article = userService.getUserById(id);
        return new ResponseEntity<UserEntity>(article, HttpStatus.OK);
    }

//    @PostMapping()
//    public ResponseEntity<Void> addArticle=(@RequestBody Article article, UriComponentsBuilder builder) {
//        boolean flag = articleService.addArticle(article);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
//        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
//    }

//    @PutMapping("article")
//    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
//        articleService.updateArticle(article);
//        return new ResponseEntity<Article>(article, HttpStatus.OK);
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
