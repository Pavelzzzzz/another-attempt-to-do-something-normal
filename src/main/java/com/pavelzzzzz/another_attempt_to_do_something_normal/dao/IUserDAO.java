package com.pavelzzzzz.another_attempt_to_do_something_normal.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.entity.UserEntity;

public interface IUserDAO {
    UserEntity getUserById(int userId);

    void addUser(UserEntity userEntity);

    void updateUser(UserEntity userEntity);

    void deleteUser(int userId);
}
