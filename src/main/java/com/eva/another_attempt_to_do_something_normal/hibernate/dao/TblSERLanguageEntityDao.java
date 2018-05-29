package com.eva.another_attempt_to_do_something_normal.hibernate.dao;

import com.eva.another_attempt_to_do_something_normal.hibernate.tables.QTblSERLanguageEntity;
import com.eva.another_attempt_to_do_something_normal.hibernate.tables.TblSERLanguageEntity;
import javax.transaction.Transactional;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TblSERLanguageEntityDao
        extends CrudRepository<TblSERLanguageEntity, Integer>,
        QuerydslPredicateExecutor<TblSERLanguageEntity>,
        QuerydslBinderCustomizer<QTblSERLanguageEntity> {

    TblSERLanguageEntity getByLanguageId(int languageId);
    TblSERLanguageEntity getByIsoCode(String isoCode);

    @Override
    default void customize(QuerydslBindings querydslBindings,
        QTblSERLanguageEntity qTblSERLanguageEntity){

    }
}
