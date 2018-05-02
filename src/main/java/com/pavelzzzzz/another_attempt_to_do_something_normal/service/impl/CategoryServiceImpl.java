package com.pavelzzzzz.another_attempt_to_do_something_normal.service.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblAPICategoryEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblSECUserEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPICategoryEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSECUserEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.CategoryService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.UserService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Category;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.User;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.CategoryDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.UserDao;
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
    private TblAPICategoryEntityDao tblAPICategoryEntityDao;
    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAllCategories(Predicate predicate, Pageable pageable) {
        List<Category> categories = new LinkedList<>();
        for(TblAPICategoryEntity tblAPICategoryEntity:
            tblAPICategoryEntityDao.findAll(predicate, pageable)){
            categories.add(categoryDao.toEntity(tblAPICategoryEntity));
        }
        return null;
    }

    @Override
    public Category getCategoryByCategoryId(@NotBlank int categoryId) {
        return categoryDao.toEntity(
            tblAPICategoryEntityDao.getUserByCategoryId(categoryId));
    }

}
