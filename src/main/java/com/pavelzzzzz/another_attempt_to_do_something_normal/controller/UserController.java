package com.pavelzzzzz.another_attempt_to_do_something_normal.controller;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.UserService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.User;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "api/administration/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> findAllUser(
            @QuerydslPredicate(root = TblSECUserEntity.class) Predicate predicate, Pageable pageable) {
        return ResponseEntity.ok(userService.findAll(predicate, pageable));
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateUser(
        @RequestBody User user){
        return new ResponseEntity<User>(userService.update(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(
        @PathVariable("id") int id) {
        userService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

//    @GetMapping("/")
//    public ResponseEntity<List<TblSECUserEntity>> getAllUser() {
//        return new ResponseEntity<List<TblSECUserEntity>>(userService.getAllUser(), HttpStatus.OK);
//    }

//    @GetMapping("/{id}")
//    public ResponseEntity<TblSECUserEntity> getUserById(@PathVariable("id") Integer id) {
//        TblSECUserEntity userEntity = tblSECUserEntityDao.getUserByUserId(id);
//        return new ResponseEntity<TblSECUserEntity>(userEntity, HttpStatus.OK);
//    }

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


}
