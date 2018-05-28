package com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.dao.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECPasswordEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECRoleEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.UserSecurity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.dao.UserSecurityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Role;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserSecurityDaoImpl implements UserSecurityDao {

  @Override
  public UserSecurity toEntity(TblSECUserEntity tblSECUserEntity) {
    List<Role> roles = new LinkedList<>();
    for (TblSECRoleEntity tblSECRoleEntity :
        tblSECUserEntity.getListRoleEntity()){
      roles.add(Role.fromId(tblSECRoleEntity.getRoleId()));
    }

    return new UserSecurity(
        tblSECUserEntity.getUserId(),
        tblSECUserEntity.getUsername(),
        tblSECUserEntity.getEmail(),
        tblSECUserEntity.getTblSECPasswordEntity().getPassword(),
        null,
        roles,
        tblSECUserEntity.isEnabled(),
        true,
        true,
        true);
  }

  @Override
  public TblSECUserEntity fromEntity(UserSecurity user) {
    List<TblSECRoleEntity> roles = new LinkedList<>();
    for (Role role : user.getAuthorities()){
      roles.add(new TblSECRoleEntity(role.getId(), role.value()));
    }
    TblSECUserEntity newTblSECUserEntity = new TblSECUserEntity(
        user.getUsername(),
        user.getEmail(),
        user.isEnabled(),
        new TblSECPasswordEntity(user.getPassword()),
        roles);
    newTblSECUserEntity.getTblSECPasswordEntity().setTblSECUserEntity(
        newTblSECUserEntity);

    return newTblSECUserEntity;
  }

}
