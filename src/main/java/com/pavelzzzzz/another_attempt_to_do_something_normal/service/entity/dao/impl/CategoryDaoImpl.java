package com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPICategoryEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Category;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.CategoryDao;
import javax.validation.constraints.NotBlank;
import org.springframework.stereotype.Component;

@Component
public class CategoryDaoImpl implements CategoryDao{

  @Override
  public Category toEntity(@NotBlank TblAPICategoryEntity tblAPICategoryEntity) {
    return new Category(
        tblAPICategoryEntity.getCategoryId(),
        tblAPICategoryEntity.getCategoryName());
  }
}
