package com.pavelzzzzz.another_attempt_to_do_something_normal.service.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblSERLanguageEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSERLanguageEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.LanguageService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.Language;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.LanguageDao;
import com.querydsl.core.types.Predicate;
import java.util.LinkedList;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LanguageServiceImpl implements LanguageService {

    @Autowired
    private TblSERLanguageEntityDao tblSERLanguageEntityDao;
    @Autowired
    private LanguageDao languageDao;

    @Override
    public List<Language> getAllLanguages(Predicate predicate, Pageable pageable) {
        List<Language> languages = new LinkedList<>();
        for (TblSERLanguageEntity tblSERLanguageEntity:
            tblSERLanguageEntityDao.findAll(predicate, pageable)){
            languages.add(languageDao.toEntity(tblSERLanguageEntity));
        }
        return languages;
    }

    @Override
    public Language getLanguageByLanguageId(@NotBlank int languageId) {
        return languageDao.toEntity(
            tblSERLanguageEntityDao.getByLanguageId(languageId));
    }
}
