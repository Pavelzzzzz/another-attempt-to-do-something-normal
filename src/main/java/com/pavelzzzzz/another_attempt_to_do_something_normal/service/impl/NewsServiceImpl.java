package com.pavelzzzzz.another_attempt_to_do_something_normal.service.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblAPLNewsEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLNewsEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.NewsService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.News;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
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

  private String createNewsBodyFromHtmlArchitecture(
      String htmlArchitecture){
    Document html = Jsoup.parse(htmlArchitecture);
    html.body().html();
    return null;
  }

  private void transformToHtmlElement(Element element) {
    for (TextNode textNode :
        element.textNodes()){
      if (textNode.text().startsWith("/~") &&
          textNode.text().endsWith("~/")){
        int textElementId =
            Integer.parseInt(
                textNode.text().replaceAll("\\D", ""));
//        textNode.text(
      }
    }
    for (Element child :
        element.children()) {
      transformToHtmlElement(child);
    }
  }
}
