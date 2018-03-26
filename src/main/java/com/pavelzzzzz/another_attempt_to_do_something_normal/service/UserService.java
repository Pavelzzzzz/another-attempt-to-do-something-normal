package com.pavelzzzzz.another_attempt_to_do_something_normal.service;

import com.pavelzzzzz.another_attempt_to_do_something_normal.dao.IUserDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.entity.TblSECUserEntity;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public List<TblSECUserEntity> getAllUser() {
        return (List<TblSECUserEntity>) userDao.findAll();
    }

    @Override
    public TblSECUserEntity getUserById(int userId) {
        return userDao.getUserByUserId(userId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.getUserByUserUsername(username);
    }

//    @Override
//    public synchronized boolean addUser(UserEntity user){
////        if (userDAO.articleExists(article.getTitle(), article.getCategory())) {
////            return false;
////        } else {
//            userDAO.save(user);
//            return true;
////        }
//    }
//
//    @Override
//    public void updateUser(UserEntity userEntity) {
//        userDAO.updateUser(userEntity);
//    }
//
//    @Override
//    public void deleteUser(int userId) {
//        userDAO.deleteUser(userId);
//    }
}
