package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.QTblSECUserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TblSECUserEntityDao
        extends CrudRepository<TblSECUserEntity, Integer>,
        QuerydslPredicateExecutor<TblSECUserEntity>,
        QuerydslBinderCustomizer<QTblSECUserEntity> {

    TblSECUserEntity getByUserId(int userId);
    TblSECUserEntity getByUsername(String username);

    @Override
    default void customize(QuerydslBindings querydslBindings, QTblSECUserEntity qTblSECUserEntity){

    }
}
