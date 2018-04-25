package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TblSECUserEntityDao extends CrudRepository<TblSECUserEntity, Integer>{
    TblSECUserEntity getUserByUserId(int userId);
    TblSECUserEntity getUserByUsername(String username);
}
