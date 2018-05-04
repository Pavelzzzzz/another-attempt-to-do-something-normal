package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.QTblAPLCategoryEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLCategoryEntity;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface TblAPLCategoryEntityDao
        extends CrudRepository<TblAPLCategoryEntity, Integer>,
        QuerydslPredicateExecutor<TblAPLCategoryEntity>,
        QuerydslBinderCustomizer<QTblAPLCategoryEntity> {

    TblAPLCategoryEntity getCategoryByCategoryId(int categoryId);
    TblAPLCategoryEntity getCategoryByCategoryName(String categoryName);

    @Override
    default void customize(QuerydslBindings querydslBindings, QTblAPLCategoryEntity qTblAPICategoryEntity){

    }
}
