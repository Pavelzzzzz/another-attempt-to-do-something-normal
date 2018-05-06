package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.QTblDESTitleTranslationEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblDESTitleTranslationEntity;
import javax.transaction.Transactional;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TblDESTitleTranslationEntityDao
    extends CrudRepository<TblDESTitleTranslationEntity, Integer>,
        QuerydslPredicateExecutor<TblDESTitleTranslationEntity>,
        QuerydslBinderCustomizer<QTblDESTitleTranslationEntity> {

    TblDESTitleTranslationEntity getTitleTranslationByTitleTranslationId(int titleTranslationId);
    TblDESTitleTranslationEntity getTitleTranslationByTitleTranslation(String titleTranslation);

    @Override
    default void customize(QuerydslBindings querydslBindings,
        QTblDESTitleTranslationEntity qTblAPICategoryEntity){

    }
}
