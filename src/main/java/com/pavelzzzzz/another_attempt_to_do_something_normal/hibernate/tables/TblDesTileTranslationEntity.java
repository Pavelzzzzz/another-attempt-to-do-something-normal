package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tblDESTileTranslation", schema = "news_blog")
public class TblDesTileTranslationEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int tileTranslationId;
    @NotBlank
    private int newsId;
    @NotBlank
    private String tileTranslation;

    public int getTileTranslationId() {
        return tileTranslationId;
    }

    public void setTileTranslationId(int tileTranslationId) {
        this.tileTranslationId = tileTranslationId;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTileTranslation() {
        return tileTranslation;
    }

    public void setTileTranslation(String tileTranslation) {
        this.tileTranslation = tileTranslation;
    }
}
