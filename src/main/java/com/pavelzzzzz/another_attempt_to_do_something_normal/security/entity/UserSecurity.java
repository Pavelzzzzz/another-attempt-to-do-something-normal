package com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity;

import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Role;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserSecurity implements UserDetails {

  private Integer userId;
  private String username;
  private String email;
  private String password;
  private String passwordConfirm;
  private Collection<Role> authorities;
  private boolean enabled;
  private boolean accountNonExpired;
  private boolean accountNonLocked;
  private boolean credentialsNonExpired;

  public UserSecurity() {
  }

  public UserSecurity(Integer userId, String username, String email, String password,
      String passwordConfirm,
      Collection<Role> authorities, boolean enabled, boolean accountNonExpired,
      boolean accountNonLocked, boolean credentialsNonExpired) {
    this.userId = userId;
    this.username = username;
    this.email = email;
    this.password = password;
    this.passwordConfirm = passwordConfirm;
    this.authorities = authorities;
    this.enabled = enabled;
    this.accountNonExpired = accountNonExpired;
    this.accountNonLocked = accountNonLocked;
    this.credentialsNonExpired = credentialsNonExpired;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  @Override
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPasswordConfirm() {
    return passwordConfirm;
  }

  public void setPasswordConfirm(String passwordConfirm) {
    this.passwordConfirm = passwordConfirm;
  }

  @Override
  public Collection<Role> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(
      Collection<Role> authorities) {
    this.authorities = authorities;
  }

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public boolean isAccountNonExpired() {
    return accountNonExpired;
  }

  public void setAccountNonExpired(boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return accountNonLocked;
  }

  public void setAccountNonLocked(boolean accountNonLocked) {
    this.accountNonLocked = accountNonLocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return credentialsNonExpired;
  }

  public void setCredentialsNonExpired(boolean credentialsNonExpired) {
    this.credentialsNonExpired = credentialsNonExpired;
  }


}
