package com.pavelzzzzz.another_attempt_to_do_something_normal.service;

import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.News;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NewsService {

  News getNewsByNewsIdAndLanguageId(int newsId, int languageId);

  int saveNews(int languageId, int categoryId,
               int userId, String title, String htmlText);

  List<News> findAll(Predicate predicate, Pageable pageable);
}
