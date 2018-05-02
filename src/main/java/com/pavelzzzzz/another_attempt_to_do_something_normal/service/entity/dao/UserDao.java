package com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.User;
import javax.validation.constraints.NotBlank;

public interface UserDao {

  User toEntity(@NotBlank TblSECUserEntity tblSECUserEntity);

//  TblSECUserEntity fromEntity (User user);

}
