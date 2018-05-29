package com.eva.another_attempt_to_do_something_normal.hibernate.dao;

import com.eva.another_attempt_to_do_something_normal.hibernate.tables.QTblAPLNewsEntity;
import com.eva.another_attempt_to_do_something_normal.hibernate.tables.TblAPLNewsEntity;

import javax.transaction.Transactional;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TblAPLNewsEntityDao
        extends CrudRepository<TblAPLNewsEntity, Integer>,
        QuerydslPredicateExecutor<TblAPLNewsEntity>,
        QuerydslBinderCustomizer<QTblAPLNewsEntity> {

    TblAPLNewsEntity getByNewsId(int newsId);

    @Override
    default void customize(QuerydslBindings querydslBindings, QTblAPLNewsEntity qTblAPLNewsEntity){
//        querydslBindings.bind(qTblAPLNewsEntity.updatedAt)
//        .all(new MultiValueBinding<DateTimePath<Date>, Date>() {
//            @Override
//            public Optional<Predicate> bind(DateTimePath<Date> dateDateTimePath,
//                Collection<? extends Date> collection) {
//                Iterator<? extends Date> iterator = collection.iterator();
//                return Optional.of(dateDateTimePath.between(iterator.next(), iterator.next()));
//            }
//        });
//
//        bindings.bind(root.year).all((path, value) -> {
//            Iterator<? extends Integer> iterator = value.iterator();
//            int year = new GregorianCalendar().get(Calendar.YEAR);
//            int delta = iterator.next();
//            return Optional.of(path.between(year - delta, year));
//        });
    }
}
