package com.pavelzzzzz.another_attempt_to_do_something_normal.service;

import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.User;
import java.util.Set;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {

    Set<User> getAllUser();

    User getUserByUserId(@NotBlank int userId);

//    boolean addUser(UserEntity user);
//
//    void updateUser(UserEntity userEntity);
//
//    void deleteUser(int userId);
}
