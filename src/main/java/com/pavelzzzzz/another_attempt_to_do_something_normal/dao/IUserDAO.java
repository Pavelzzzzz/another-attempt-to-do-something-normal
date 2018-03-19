package com.pavelzzzzz.another_attempt_to_do_something_normal.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IUserDAO extends CrudRepository<UserEntity, Integer> {
    UserEntity getUserByUserId(int userId);
}
