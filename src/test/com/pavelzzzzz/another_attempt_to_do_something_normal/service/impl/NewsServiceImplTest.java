package com.pavelzzzzz.another_attempt_to_do_something_normal.service.impl;

import static org.junit.Assert.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class NewsServiceImplTest {

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
    System.out.println(textList);
  }

  private void fun(Element element, List<String> textList){
    textList.add(element.ownText());
    for(Element child :
            element.children()){
      fun(child, textList);
    }

  }

}