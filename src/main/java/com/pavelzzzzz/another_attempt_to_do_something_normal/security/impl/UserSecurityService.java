package com.pavelzzzzz.another_attempt_to_do_something_normal.security.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblSECUserEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.IUserSecurityService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.UserSecurity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.dao.UserSecurityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Role;
import java.util.Collections;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserSecurityService implements IUserSecurityService {

    @Autowired
    private TblSECUserEntityDao tblSECUserEntityDao;
    @Autowired
    private UserSecurityDao userSecurityDao;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserSecurity loadUserByUsername(String username) throws UsernameNotFoundException {
        TblSECUserEntity tblSECUserEntity =
            tblSECUserEntityDao.getByUsername(username);
        if(tblSECUserEntity == null){
            throw new UsernameNotFoundException(username);
        }
        return userSecurityDao.toEntity(tblSECUserEntity);
    }

    @Override
    public int save(UserSecurity newUserSecurity) {
        newUserSecurity.setPassword(encoder.encode(newUserSecurity.getPassword()));
        newUserSecurity.setAuthorities(Collections.singletonList(Role.User));
        newUserSecurity.setEnabled(true);
        newUserSecurity.setAccountNonExpired(true);
        newUserSecurity.setAccountNonLocked(true);
        newUserSecurity.setCredentialsNonExpired(true);
        TblSECUserEntity newTblSECUserEntity = tblSECUserEntityDao.save(
            userSecurityDao.fromEntity(newUserSecurity));
        return newTblSECUserEntity.getUserId();
    }

}
