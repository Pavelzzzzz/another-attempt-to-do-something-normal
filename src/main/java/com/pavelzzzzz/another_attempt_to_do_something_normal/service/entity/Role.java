package com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority{
  Admin("Admin", 1), User("User", 2);

  private String value;
  private int id;

  Role(String value, int id) {
    this.value = value; this.id = id;
  }

  @Override
  public String getAuthority() {
    return "ROLE_" + name();
  }

  public int getId(){
    return id;
  }

  public String value() {
    return value;
  }

  public static Role fromId(int roleId) {
    for (Role role : Role.values()) {
      if (role.id ==  roleId) {
        return role;
      }
    }
    throw new IllegalArgumentException(String.format("No role with id %d ", roleId));
  }
}
