package com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.UserSecurity;
import javax.validation.constraints.NotBlank;

public interface UserSecurityDao {

  UserSecurity toEntity(@NotBlank TblSECUserEntity tblSECUserEntity);

  TblSECUserEntity fromEntity (UserSecurity user);

}
