package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import com.pavelzzzzz.another_attempt_to_do_something_normal.entity.UserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public ResponseEntity<List<UserEntity>> getAllUser() {
        return new ResponseEntity<List<UserEntity>>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Integer id) {
        UserEntity userEntity = userService.getUserById(id);
        return new ResponseEntity<UserEntity>(userEntity, HttpStatus.OK);
    }

//    @PostMapping("/")
//    public ResponseEntity<Void> addUser(@RequestBody String login,
//                                        @RequestBody String email) {
//        if (userService.addUser(login, email)) {
//
//            HttpHeaders headers = new HttpHeaders();
//
//            headers.setLocation(builder.path("/article/{id}").buildAndExpand(article.getArticleId()).toUri());
//
//        }
//    }

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

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
//        userService.deleteUser(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }
}
