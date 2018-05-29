package com.eva.another_attempt_to_do_something_normal.service;

import com.eva.another_attempt_to_do_something_normal.service.entity.NewsHeader;
import com.querydsl.core.types.Predicate;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface NewsHeaderService {

  List<NewsHeader> findAll(Predicate predicate, Pageable pageable, int languageId);
}
