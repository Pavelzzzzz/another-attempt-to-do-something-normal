package com.eva.another_attempt_to_do_something_normal.service;

import com.eva.another_attempt_to_do_something_normal.service.entity.Language;
import com.querydsl.core.types.Predicate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import org.springframework.data.domain.Pageable;

public interface LanguageService {

    List<Language> findAll(Predicate predicate, Pageable pageable);

    Language getLanguageByLanguageId(@NotBlank int languageId);
}
