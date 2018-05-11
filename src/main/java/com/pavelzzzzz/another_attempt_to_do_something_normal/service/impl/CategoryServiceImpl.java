package com.pavelzzzzz.another_attempt_to_do_something_normal.service.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblAPLCategoryEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLCategoryEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.CategoryService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Category;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.CategoryDao;
import com.querydsl.core.types.Predicate;
import java.util.LinkedList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private TblAPLCategoryEntityDao tblAPLCategoryEntityDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories(Predicate predicate, Pageable pageable) {
        List<Category> categories = new LinkedList<>();
        for(TblAPLCategoryEntity tblAPLCategoryEntity:
            tblAPLCategoryEntityDao.findAll(predicate, pageable)){
            categories.add(categoryDao.toEntity(tblAPLCategoryEntity));
        }
        return categories;
    }

    @Override
    public Category getCategoryByCategoryId(@NotBlank int categoryId) {
        return categoryDao.toEntity(
            tblAPLCategoryEntityDao.getByCategoryId(categoryId));
    }

}
