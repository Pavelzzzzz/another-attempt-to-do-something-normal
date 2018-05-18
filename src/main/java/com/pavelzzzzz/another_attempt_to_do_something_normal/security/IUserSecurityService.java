package com.pavelzzzzz.another_attempt_to_do_something_normal.security;

import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.UserSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;

  public interface IUserSecurityService extends UserDetailsService {

    int save(UserSecurity newUserSecurity);
  }
