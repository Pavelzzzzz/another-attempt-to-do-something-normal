package com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSERLanguageEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Language;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.LanguageDao;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class LanguageDaoImpl implements LanguageDao{

  @Override
  public Language toEntity(@NotBlank TblSERLanguageEntity tblSERLanguageEntity) {
    return new Language(
        tblSERLanguageEntity.getLanguageId(),
        tblSERLanguageEntity.getIsoCode());
  }
}
