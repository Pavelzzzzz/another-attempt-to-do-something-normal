package com.pavelzzzzz.another_attempt_to_do_something_normal.security.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblSECUserEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.IUserSecurityService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.UserSecurity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.dao.UserSecurityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserSecurityService implements IUserSecurityService {

    @Autowired
    private TblSECUserEntityDao tblSECUserEntityDao;
    @Autowired
    private UserSecurityDao userSecurityDao;

    @Override
    public UserSecurity loadUserByUsername(String username) throws UsernameNotFoundException {
        TblSECUserEntity tblSECUserEntity =
            tblSECUserEntityDao.getUserByUsername(username);
        if(tblSECUserEntity == null){
            throw new UsernameNotFoundException(username);
        }
        return userSecurityDao.toEntity(tblSECUserEntity);
    }
}
