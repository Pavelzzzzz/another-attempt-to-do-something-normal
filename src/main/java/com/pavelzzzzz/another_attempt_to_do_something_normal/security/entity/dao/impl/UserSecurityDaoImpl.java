package com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.dao.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECRoleEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.UserSecurity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.dao.UserSecurityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Role;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;

@Component
public class UserSecurityDaoImpl implements UserSecurityDao {

  @Override
  public UserSecurity toEntity(TblSECUserEntity tblSECUserEntity) {
    Collection<Role> roles = new HashSet<>();
    for (TblSECRoleEntity tblSECRoleEntity :
        tblSECUserEntity.getListRoleEntity()){
      roles.add(Role.fromId(tblSECRoleEntity.getRoleId()));
    }

    return new UserSecurity(
        tblSECUserEntity.getUserId(),
        tblSECUserEntity.getUsername(),
        tblSECUserEntity.getEmail(),
        tblSECUserEntity.getTblSECPasswordEntity().getPassword(),
        roles,
        tblSECUserEntity.isEnabled(),
        true,
        true,
        true);
  }

//  @Override
//  public TblSECUserEntity fromEntity(User user) {
//    return null;
//  }
}
