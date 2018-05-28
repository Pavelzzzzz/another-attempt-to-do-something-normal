package com.pavelzzzzz.another_attempt_to_do_something_normal.security;

import com.pavelzzzzz.another_attempt_to_do_something_normal.security.entity.UserSecurity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

  @Autowired
  private UserService userService;

  @Override
  public boolean supports(Class<?> aClass) {
    return UserSecurity.class.equals(aClass);
  }

  @Override
  public void validate(@Nullable Object o, Errors errors) {
    UserSecurity userSecurity = (UserSecurity) o;

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
    if (userSecurity.getUsername().length() < 3
        || userSecurity.getUsername().length() > 256){
      errors.rejectValue("username", "Size.userForm.username");
    }
    if (userService.getByUsername(userSecurity.getUsername()) != null) {
      errors.rejectValue("username", "Duplicate.userForm.username");
    }

    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
    if (userSecurity.getPassword().length() < 6 || userSecurity.getPassword().length() > 256) {
      errors.rejectValue("password", "Size.userForm.password");
    }
    if (!userSecurity.getPasswordConfirm().equals(userSecurity.getPassword())) {
      errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
    }
  }
}
