package com.pavelzzzzz.another_attempt_to_do_something_normal.service;

import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.News;

public interface NewsService {

  News getNewsByLanguageIdAndNewsId(Integer languageId, Integer newsId);
}
