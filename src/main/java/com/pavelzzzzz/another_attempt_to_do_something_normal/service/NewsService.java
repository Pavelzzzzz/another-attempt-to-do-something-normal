package com.pavelzzzzz.another_attempt_to_do_something_normal.service;

import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.News;

public interface NewsService {

  News getNewsByNewsIdAndLanguageId(int newsId, int languageId);

  int save(int languageId, int categoryId,
               int userId, String title, String htmlText);

  int update(int newsId, int languageId,
      int categoryId, String title, String htmlText);

  void delete(int newsId);
}
