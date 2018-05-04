package com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLCategoryEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Category;
import javax.validation.constraints.NotBlank;

public interface CategoryDao {

  Category toEntity(@NotBlank TblAPLCategoryEntity tblAPICategoryEntity);
}
