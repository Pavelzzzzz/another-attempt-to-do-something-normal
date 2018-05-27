package com.pavelzzzzz.another_attempt_to_do_something_normal.service;

import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.User;
import com.querydsl.core.types.Predicate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.data.domain.Pageable;

public interface UserService {

  List<User> findAll(Predicate predicate, Pageable pageable);

  User getByUserId(@NotBlank int userId);

  User getByUsername(String username);

  User update(User user);

  void delete(int userId);

//    void updateUser(UserEntity userEntity);
//

}
