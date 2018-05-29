package com.eva.another_attempt_to_do_something_normal.service.impl;

import com.eva.another_attempt_to_do_something_normal.hibernate.dao.TblAPLCategoryEntityDao;
import com.eva.another_attempt_to_do_something_normal.hibernate.tables.TblAPLCategoryEntity;
import com.eva.another_attempt_to_do_something_normal.service.CategoryService;
import com.eva.another_attempt_to_do_something_normal.service.entity.Category;
import com.eva.another_attempt_to_do_something_normal.service.entity.dao.CategoryDao;
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
    public List<Category> findAll(Predicate predicate, Pageable pageable) {
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

    @Override
    public Category save(Category category) {
        return categoryDao.toEntity(
            tblAPLCategoryEntityDao.save(
                categoryDao.fromEntity(category)));
    }

    @Override
    public void delete(int categoryId) {
        tblAPLCategoryEntityDao.delete(
            tblAPLCategoryEntityDao.getByCategoryId(categoryId));
    }
}
