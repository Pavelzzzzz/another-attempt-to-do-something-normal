package com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSERLanguageEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Language;
import javax.validation.constraints.NotBlank;

public interface LanguageDao {

  Language toEntity(@NotBlank TblSERLanguageEntity tblSERLanguageEntity);
}
