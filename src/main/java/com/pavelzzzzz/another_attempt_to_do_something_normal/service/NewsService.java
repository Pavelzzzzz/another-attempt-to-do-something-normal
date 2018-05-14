package com.pavelzzzzz.another_attempt_to_do_something_normal.service;

import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.News;

public interface NewsService {

  News getNewsByNewsIdAndLanguageId(int newsId, int languageId);

  int saveNews(int languageId, int categoryId,
               int userId, String title, String htmlText);
}
