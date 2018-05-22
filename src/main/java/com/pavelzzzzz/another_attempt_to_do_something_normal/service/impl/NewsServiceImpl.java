package com.pavelzzzzz.another_attempt_to_do_something_normal.service.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblAPLCategoryEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblAPLNewsEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblDESTextTranslationEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblSECUserEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblSERLanguageEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLNewsEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.NewsService;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.News;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.CategoryDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.LanguageDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity.dao.UserDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.service.text_code_transformations.Transformer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService {

  @Autowired
  private TblSECUserEntityDao tblSECUserEntityDao;
  @Autowired
  private TblAPLNewsEntityDao tblAPLNewsEntityDao;
  @Autowired
  private TblSERLanguageEntityDao tblSERLanguageEntityDao;
  @Autowired
  private TblAPLCategoryEntityDao tblAPLCategoryEntityDao;
  @Autowired
  private TblDESTextTranslationEntityDao tblDESTextTranslationEntityDao;
  @Autowired
  private LanguageDao languageDao;
  @Autowired
  private CategoryDao categoryDao;
  @Autowired
  private UserDao userDao;
  @Autowired
  private Transformer codeToTextTransformer;
  @Autowired
  private Transformer textToCodeTransformer;

  @Override
  public News getNewsByNewsIdAndLanguageId(int newsId, int languageId) {
    TblAPLNewsEntity tblAPLNewsEntity =
        tblAPLNewsEntityDao.getByNewsId(newsId);

    Document html = Jsoup.parse(tblAPLNewsEntity.getHtmlArchitecture());
    transformHtmlElement(html.body(), languageId, codeToTextTransformer);

    return new News(tblAPLNewsEntity.getNewsId(),
        languageDao.toEntity(tblSERLanguageEntityDao.getByLanguageId(languageId)),
        categoryDao.toEntity(tblAPLNewsEntity.getTblAPICategoryEntity()),
        tblAPLNewsEntity.getCreatedAt(),
        tblAPLNewsEntity.getUpdatedAt(),
        userDao.toEntity(tblAPLNewsEntity.getTblSECUserEntity()),
        tblDESTextTranslationEntityDao.getByPrimaryKeyTextIdLanguageId(
            new TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId(
                tblAPLNewsEntity.getTitleId(),
                languageId))
            .getTextTranslation(),
        html.body().outerHtml());
  }

  @Override
  public int saveNews(int languageId, int categoryId,
                      int userId, String title, String htmlText){

    Document html = Jsoup.parse(htmlText);
    transformHtmlElement(html.body() ,languageId, textToCodeTransformer);

    TblAPLNewsEntity tblAPLNewsEntity = new TblAPLNewsEntity(
        tblAPLCategoryEntityDao.getByCategoryId(categoryId),
        tblSECUserEntityDao.getByUserId(userId),
        Integer.parseInt(
            textToCodeTransformer.transform(title, languageId)
                .replaceAll("\\D", "")),
        html.body().outerHtml());

    int newsId = tblAPLNewsEntityDao.save(tblAPLNewsEntity).getNewsId();
    return newsId;
  }

  private void transformHtmlElement(Element element, int languageId, Transformer transformer) {
    for (TextNode textNode :
        element.textNodes()){
      textNode.text(
          transformer.transform(textNode.text(), languageId));
    }
    for (Element child :
        element.children()) {
      transformHtmlElement(child, languageId, transformer);
    }
  }
}
