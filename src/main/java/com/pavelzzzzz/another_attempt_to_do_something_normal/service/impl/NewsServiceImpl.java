package com.pavelzzzzz.another_attempt_to_do_something_normal.service.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblAPLNewsEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLNewsEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.NewsService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;

public class NewsServiceImpl implements NewsService {

//  @Autowired
//  private NewsDao newsDao;
  @Autowired
  private TblAPLNewsEntityDao tblAPLNewsEntityDao;
  @Autowired


  @Override
  public News getNewsByLanguageIdAndNewsId(
      Integer languageId, Integer newsId) {
    TblAPLNewsEntity tblAPLNewsEntity =
        tblAPLNewsEntityDao.getNewsByNewsId(newsId);
    return null;
  }

  private String createNewsBodyFromXmlArchitecture(
      String htmlArchitecture){
    Document html = Jsoup.parse(htmlArchitecture);
//    html.body().ge
    return null;
  }
}
