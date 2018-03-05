package com.pavelzzzzz.another_attempt_to_do_something_normal.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.entity.UserEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

@Transactional
@Repository
public class UserDAO implements IUserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public UserEntity getUserById(int userId) {
        return entityManager.find(UserEntity.class, userId);
    }

    @Override
    public void addUser(UserEntity userEntity) {
        entityManager.persist(userEntity);
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        UserEntity userEntityChangeable = getUserById(userEntity.getUserId());
        userEntityChangeable.setUsername(userEntity.getUsername());
        userEntityChangeable.setEmail(userEntity.getEmail());
        userEntityChangeable.setIsActive(userEntity.getIsActive());
        entityManager.flush();
    }

    @Override
    public void deleteUser(int userId) {
        entityManager.remove(getUserById(userId));
    }

}
