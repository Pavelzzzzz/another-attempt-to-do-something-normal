package com.pavelzzzzz.another_attempt_to_do_something_normal.repository;

import com.pavelzzzzz.another_attempt_to_do_something_normal.domain.TblSecUserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<TblSecUserEntity, Long> {
}
