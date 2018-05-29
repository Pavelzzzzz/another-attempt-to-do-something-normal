package com.eva.another_attempt_to_do_something_normal.hibernate.dao;

import com.eva.another_attempt_to_do_something_normal.hibernate.tables.QTblDESTextTranslationEntity;
import com.eva.another_attempt_to_do_something_normal.hibernate.tables.TblDESTextTranslationEntity;
import com.eva.another_attempt_to_do_something_normal.hibernate.tables.TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TblDESTextTranslationEntityDao
        extends CrudRepository<TblDESTextTranslationEntity,
    TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId>,
        QuerydslPredicateExecutor<TblDESTextTranslationEntity>,
        QuerydslBinderCustomizer<QTblDESTextTranslationEntity> {

    TblDESTextTranslationEntity getByPrimaryKeyTextIdLanguageId(
        TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId primaryKeyTextIdLanguageId);

    List<TblDESTextTranslationEntity> findAllByPrimaryKeyTextIdLanguageIdTextId (
        int textId);

    @Procedure(name = "do_create_tblDESTextTranslationEntity")
    int create_tblDESTextTranslationEntity(
        @Param("textId") int textId,
        @Param("languageId") int languageId,
        @Param("textTranslation") String textTranslation);

    @Override
    default void customize(QuerydslBindings querydslBindings,
        QTblDESTextTranslationEntity qTblDESTextTranslationEntity){
    }
}
