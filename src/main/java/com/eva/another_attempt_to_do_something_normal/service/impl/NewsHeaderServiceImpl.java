package com.eva.another_attempt_to_do_something_normal.service.impl;

import com.eva.another_attempt_to_do_something_normal.hibernate.dao.TblSERLanguageEntityDao;
import com.eva.another_attempt_to_do_something_normal.hibernate.tables.TblAPLNewsEntity;
import com.eva.another_attempt_to_do_something_normal.service.entity.dao.CategoryDao;
import com.eva.another_attempt_to_do_something_normal.hibernate.dao.TblAPLNewsEntityDao;
import com.eva.another_attempt_to_do_something_normal.hibernate.dao.TblDESTextTranslationEntityDao;
import com.eva.another_attempt_to_do_something_normal.hibernate.tables.TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId;
import com.eva.another_attempt_to_do_something_normal.service.NewsHeaderService;
import com.eva.another_attempt_to_do_something_normal.service.entity.NewsHeader;
import com.eva.another_attempt_to_do_something_normal.service.entity.dao.LanguageDao;
import com.eva.another_attempt_to_do_something_normal.service.entity.dao.UserDao;
import com.querydsl.core.types.Predicate;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class NewsHeaderServiceImpl implements NewsHeaderService {

  @Autowired
  private TblAPLNewsEntityDao tblAPLNewsEntityDao;
  @Autowired
  private TblSERLanguageEntityDao tblSERLanguageEntityDao;
  @Autowired
  private TblDESTextTranslationEntityDao tblDESTextTranslationEntityDao;
  @Autowired
  private LanguageDao languageDao;
  @Autowired
  private CategoryDao categoryDao;
  @Autowired
  private UserDao userDao;

  @Override
  public List<NewsHeader> findAll(Predicate predicate, Pageable pageable, int languageId) {
    List<NewsHeader> newsHeaders = new LinkedList<>();
    for(TblAPLNewsEntity tblAPLNewsEntity:
        tblAPLNewsEntityDao.findAll(predicate, pageable)){
      newsHeaders.add(
          new NewsHeader(
              tblAPLNewsEntity.getNewsId(),
              languageDao.toEntity(tblSERLanguageEntityDao.getByLanguageId(languageId)),
              categoryDao.toEntity(tblAPLNewsEntity.getTblAPICategoryEntity()),
              tblAPLNewsEntity.getCreatedAt(),
              tblAPLNewsEntity.getUpdatedAt(),
              userDao.toEntity(tblAPLNewsEntity.getTblSECUserEntity()),
              tblDESTextTranslationEntityDao.getByPrimaryKeyTextIdLanguageId(
                  new TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId(
                      tblAPLNewsEntity.getTitleId(),
                      languageId))
                  .getTextTranslation()));
    }
    return newsHeaders;
  }
}
