package com.pavelzzzzz.another_attempt_to_do_something_normal.service;

import com.pavelzzzzz.another_attempt_to_do_something_normal.dao.IUserDAO;
import com.pavelzzzzz.another_attempt_to_do_something_normal.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDAO userDAO;

    @Override
    public UserEntity getUserById(int userId) {
        UserEntity obj = userDAO.getUserById(userId);
        return obj;
    }

    @Override
    public synchronized boolean addUser(UserEntity user){
//        if (userDAO.articleExists(article.getTitle(), article.getCategory())) {
//            return false;
//        } else {
            userDAO.addUser(user);
            return true;
//        }
    }

    @Override
    public void updateUser(UserEntity userEntity) {
        userDAO.updateUser(userEntity);
    }

    @Override
    public void deleteUser(int userId) {
        userDAO.deleteUser(userId);
    }
}
