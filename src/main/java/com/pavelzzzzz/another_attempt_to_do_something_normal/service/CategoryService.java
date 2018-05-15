package com.pavelzzzzz.another_attempt_to_do_something_normal.service;

import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Category;
import com.querydsl.core.types.Predicate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    List<Category> findAll(Predicate predicate, Pageable pageable);

    Category getCategoryByCategoryId(@NotBlank int categoryId);
}
