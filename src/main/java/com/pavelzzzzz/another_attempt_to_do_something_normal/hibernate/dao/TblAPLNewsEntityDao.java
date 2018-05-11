package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.QTblAPLNewsEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLNewsEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TblAPLNewsEntityDao
        extends CrudRepository<TblAPLNewsEntity, Integer>,
        QuerydslPredicateExecutor<TblAPLNewsEntity>,
        QuerydslBinderCustomizer<QTblAPLNewsEntity> {

    TblAPLNewsEntity getByNewsId(int newsId);

    @Override
    default void customize(QuerydslBindings querydslBindings, QTblAPLNewsEntity qTblAPLNewsEntity){

    }
}
