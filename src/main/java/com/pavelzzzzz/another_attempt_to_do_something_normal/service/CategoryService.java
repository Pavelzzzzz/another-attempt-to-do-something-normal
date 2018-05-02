package com.pavelzzzzz.another_attempt_to_do_something_normal.service;

import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Category;
import com.querydsl.core.types.Predicate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    List<Category> getAllCategories(Predicate predicate, Pageable pageable);

    Category getCategoryByCategoryId(@NotBlank int categoryId);

//    boolean addUser(UserEntity user);
//
//    void updateUser(UserEntity userEntity);
//
//    void deleteUser(int userId);
}
