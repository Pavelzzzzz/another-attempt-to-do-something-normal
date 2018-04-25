package com.pavelzzzzz.another_attempt_to_do_something_normal.service.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblSECUserEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.IUserService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.User;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.UserDao;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private TblSECUserEntityDao tblSECUserEntityDao;
    @Autowired
    private UserDao userDao;

    @Override
    public Set<User> getAllUser() {
        Set<User> users = new HashSet<User>();
        for(TblSECUserEntity tblSECUserEntity:
            tblSECUserEntityDao.findAll()){
            users.add(userDao.toEntity(tblSECUserEntity));
        }
        return users;
    }

    @Override
    public User getUserByUserId(int userId) {
        return userDao.toEntity(tblSECUserEntityDao.getUserByUserId(userId));
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        TblSECUserEntity tblSECUserEntity =
            tblSECUserEntityDao.getUserByUsername(username);
        if(tblSECUserEntity == null){
            throw new UsernameNotFoundException(username);
        }
        return userDao.toEntity(tblSECUserEntity);
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
