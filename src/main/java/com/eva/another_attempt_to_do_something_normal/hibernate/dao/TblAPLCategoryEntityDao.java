package com.eva.another_attempt_to_do_something_normal.hibernate.dao;

import com.eva.another_attempt_to_do_something_normal.hibernate.tables.QTblAPLCategoryEntity;
import com.eva.another_attempt_to_do_something_normal.hibernate.tables.TblAPLCategoryEntity;
import com.querydsl.core.types.dsl.StringExpression;
import javax.transaction.Transactional;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TblAPLCategoryEntityDao
        extends CrudRepository<TblAPLCategoryEntity, Integer>,
        QuerydslPredicateExecutor<TblAPLCategoryEntity>,
        QuerydslBinderCustomizer<QTblAPLCategoryEntity> {

    TblAPLCategoryEntity getByCategoryId(int categoryId);
    TblAPLCategoryEntity getByCategoryName(String categoryName);

    @Override
    default void customize(QuerydslBindings querydslBindings, QTblAPLCategoryEntity qTblAPICategoryEntity){
        querydslBindings.bind(qTblAPICategoryEntity.categoryName)
            .first(StringExpression::containsIgnoreCase);
    }
}
