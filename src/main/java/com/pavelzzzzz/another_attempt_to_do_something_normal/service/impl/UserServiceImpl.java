package com.pavelzzzzz.another_attempt_to_do_something_normal.service.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblSECUserEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.UserService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.User;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.UserDao;
import com.querydsl.core.types.Predicate;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TblSECUserEntityDao tblSECUserEntityDao;
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll(Predicate predicate, Pageable pageable) {
        List<User> users = new LinkedList<>();
        for(TblSECUserEntity tblSECUserEntity:
            tblSECUserEntityDao.findAll(predicate, pageable)){
            users.add(userDao.toEntity(tblSECUserEntity));
        }
        return users;
    }

    @Override
    public User getByUserId(int userId) {
        return userDao.toEntity(tblSECUserEntityDao.getByUserId(userId));
    }

    @Override
    public User getByUsername(String username) {
        return userDao.toEntity(tblSECUserEntityDao.getByUsername(username));
    }

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
