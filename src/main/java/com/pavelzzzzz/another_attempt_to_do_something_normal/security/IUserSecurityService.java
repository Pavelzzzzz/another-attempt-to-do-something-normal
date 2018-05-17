package com.pavelzzzzz.another_attempt_to_do_something_normal.security;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserSecurityService extends UserDetailsService {

  int registrationNewUser(String username, String email, String password);

}
