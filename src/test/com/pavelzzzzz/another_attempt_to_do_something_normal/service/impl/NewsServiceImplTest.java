package com.pavelzzzzz.another_attempt_to_do_something_normal.service.impl;

import static org.junit.Assert.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

public class NewsServiceImplTest {

  private final String htmlText = "<div style=\"text-align: center;\">"
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
    Elements allElements = html.body().getAllElements();
    for (Element elements :
        allElements){
      System.out.println(elements);
      System.out.println();
    }
  }

}