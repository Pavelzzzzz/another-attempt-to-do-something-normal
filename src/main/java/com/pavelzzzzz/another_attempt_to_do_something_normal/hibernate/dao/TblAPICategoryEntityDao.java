package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.QTblAPICategoryEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPICategoryEntity;
import javax.transaction.Transactional;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TblAPICategoryEntityDao
        extends CrudRepository<TblAPICategoryEntity, Integer>,
        QuerydslPredicateExecutor<TblAPICategoryEntity>,
        QuerydslBinderCustomizer<QTblAPICategoryEntity> {

    TblAPICategoryEntity getUserByCategoryId(int categoryId);
    TblAPICategoryEntity getUserByCategoryName(String categoryName);

    @Override
    default void customize(QuerydslBindings querydslBindings, QTblAPICategoryEntity qTblAPICategoryEntity){

    }
}
