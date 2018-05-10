package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.QTblDESTextTranslationEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblDESTextTranslationEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId;
import javax.transaction.Transactional;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TblDESTextTranslationEntityDao
        extends CrudRepository<TblDESTextTranslationEntity,
    TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId>,
        QuerydslPredicateExecutor<TblDESTextTranslationEntity>,
        QuerydslBinderCustomizer<QTblDESTextTranslationEntity> {

    TblDESTextTranslationEntity getTextTranslationByPrimaryKey(
        TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId id);

    @Override
    default void customize(QuerydslBindings querydslBindings,
        QTblDESTextTranslationEntity qTblDESTextTranslationEntity){

    }
}
