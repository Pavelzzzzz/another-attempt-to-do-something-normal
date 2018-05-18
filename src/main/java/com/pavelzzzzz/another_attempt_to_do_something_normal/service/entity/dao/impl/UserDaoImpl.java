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
    if (tblSECUserEntity == null) {
      return null;
    }

    Collection<Role> roles = new HashSet<>();
    for (TblSECRoleEntity tblSECRoleEntity :
        tblSECUserEntity.getListRoleEntity()){
      roles.add(Role.fromId(tblSECRoleEntity.getRoleId()));
    }

    return new User(
        tblSECUserEntity.getUserId(),
        tblSECUserEntity.getUsername(),
        tblSECUserEntity.getEmail(),
        roles,
        tblSECUserEntity.isEnabled(),
        true,
        true,
        true);
  }
}
