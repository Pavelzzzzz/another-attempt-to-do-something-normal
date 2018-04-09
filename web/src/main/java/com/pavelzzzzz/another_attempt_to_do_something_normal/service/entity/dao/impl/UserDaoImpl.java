package com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECRoleEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Role;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.User;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.UserDao;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {

  @Override
  public User toEntity(TblSECUserEntity tblSECUserEntity) {
    Collection<Role> roles = new HashSet<>();
    for (TblSECRoleEntity tblSECRoleEntity :
        tblSECUserEntity.getListRoleEntity()){
      roles.add(Role.fromId(tblSECRoleEntity.getRoleId()));
    }

    return User.builder()
        .userId(tblSECUserEntity.getUserId())
        .username(tblSECUserEntity.getUsername())
        .email(tblSECUserEntity.getEmail())
        .password(tblSECUserEntity.getTblSECPasswordEntity().getPassword())
        .authorities(roles)
        .enabled(tblSECUserEntity.isEnabled())
        .accountNonExpired(true)
        .accountNonLocked(true)
        .credentialsNonExpired(true)
        .build();
  }

//  @Override
//  public TblSECUserEntity fromEntity(User user) {
//    return null;
//  }
}
