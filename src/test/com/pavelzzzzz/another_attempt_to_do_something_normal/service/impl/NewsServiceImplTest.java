package com.pavelzzzzz.another_attempt_to_do_something_normal.service.impl;

import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblAPLCategoryEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblAPLNewsEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblDESTextTranslationEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblSECUserEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.dao.TblSERLanguageEntityDao;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLCategoryEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblAPLNewsEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblDESTextTranslationEntity;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId;
import com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables.TblSERLanguageEntity;
import javax.transaction.Transactional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class NewsServiceImplTest {

  @Autowired
  private TblDESTextTranslationEntityDao tblDESTextTranslationEntityDao;
  @Autowired
  private TblSERLanguageEntityDao tblSERLanguageEntityDao;
  @Autowired
  private TblAPLNewsEntityDao tblAPLNewsEntityDao;
  @Autowired
  private TblSECUserEntityDao tblSECUserEntityDao;
  @Autowired
  private TblAPLCategoryEntityDao tblAPLCategoryEntityDao;

  private final String htmlText = "qqqqqqqqqqq<div>wwwwwwwwwwww</div><div>eeeeee</div>"
      + "<div style=\"text-align: center;\">"
      + "<span style=\"font-size: 14px; font-weight: bold;\">sdjlfjksdnfasd</span>"
      + "</div>"
      + "<div style=\"text-align: center;\">"
      + "<span style=\"font-size: 14px; font-weight: bold;\"><br></span>"
      + "</div>"
      + "<div style=\"text-align: left;\">Zil crut!!!&nbsp; &nbsp; &nbsp; "
      + "<span style=\"font-weight: bold; font-style: italic;\">Zil crut!!!</span></div>";

  @Test
  public void getNewsByLanguageIdAndNewsId() {
    Document html = Jsoup.parse(htmlText);
    List<String> textList = new LinkedList<>();
    fun(html.body(), textList);
//    System.out.println(textList);
    String[] strings = {};
    html.body().outerHtml();
  }

  private void fun(Element element, List<String> textList){
    if (element.ownText().length() != 0){
      textList.add(element.ownText());
      element.text(element.ownText());
      System.out.println(element.ownText());
    }

    for(Element child :
            element.children()){
      fun(child, textList);
    }
    System.out.println(
            Long.parseLong(";23;3;11;44;66;77;44...........".replaceAll("\\D",""))
    );

  }

  @Test
  public void hibernateProcedure(){
    int result = tblDESTextTranslationEntityDao.create_tblDESTextTranslationEntity(
        -1, 1, "ZiL++");
    System.out.println(result);
//    System.out.println(
//        tblDESTextTranslationEntityDao.create_tblDESTextTranslationEntity(
//            -1, 1, "ZiL++").getTextTranslation());
  }

  @Test
//  @Transactional
  public void hibernateSave(){

//    tblSERLanguageEntityDao.save(new TblSERLanguageEntity("is2"));
//    tblAPLCategoryEntityDao.save( new TblAPLCategoryEntity("+++"));
    tblAPLNewsEntityDao.save(new TblAPLNewsEntity(
        tblAPLCategoryEntityDao.getByCategoryId(19),
        tblSECUserEntityDao.getByUserId(1),
        1,
        ""
    ));
  }

//  public TblAPLNewsEntity(
//      @NotBlank TblAPLCategoryEntity tblAPICategoryEntity,
//      @NotBlank TblSECUserEntity tblSECUserEntity,
//      @NotBlank int titleId,
//      @NotBlank String htmlArchitecture)

}