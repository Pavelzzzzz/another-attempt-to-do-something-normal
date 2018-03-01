package com.pavelzzzzz.another_attempt_to_do_something_normal.service;

import com.pavelzzzzz.another_attempt_to_do_something_normal.entity.UserEntity;

public interface IUserService {
    UserEntity getUserById(int userId);

    boolean addUser(UserEntity user);

    void updateUser(UserEntity userEntity);

    void deleteUser(int userId);
}
