package com.eva.another_attempt_to_do_something_normal.service.entity;

import java.util.List;

public class User {

  private int userId;
  private String username;
  private String email;
  private List<Role> authorities;
  private boolean enabled;

  public User() {
  }

  public User(int userId, String username, String email,
      List<Role> authorities, boolean enabled) {
    this.userId = userId;
    this.username = username;
    this.email = email;
    this.authorities = authorities;
    this.enabled = enabled;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

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

  public List<Role> getAuthorities() {
    return authorities;
  }

  public void setAuthorities(List<Role> authorities) {
    this.authorities = authorities;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
}
