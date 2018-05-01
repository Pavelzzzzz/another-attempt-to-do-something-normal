package com.pavelzzzzz.another_attempt_to_do_something_normal.service;

import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.User;
import com.querydsl.core.types.Predicate;
import java.util.List;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    List<User> getAllUser(Predicate predicate, Pageable pageable);

    User getUserByUserId(@NotBlank int userId);

//    boolean addUser(UserEntity user);
//
//    void updateUser(UserEntity userEntity);
//
//    void deleteUser(int userId);
}
