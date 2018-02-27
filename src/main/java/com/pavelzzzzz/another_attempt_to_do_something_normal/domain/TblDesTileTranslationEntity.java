package com.pavelzzzzz.another_attempt_to_do_something_normal.domain;

import javax.persistence.*;

@Entity
@Table(name = "tblDESTileTranslation", schema = "news_blog", catalog = "")
public class TblDesTileTranslationEntity {
    private int tileTranslationId;
    private int newsId;
    private String tileTranslation;

    @Id
    @Column(name = "TileTranslationId")
    public int getTileTranslationId() {
        return tileTranslationId;
    }

    public void setTileTranslationId(int tileTranslationId) {
        this.tileTranslationId = tileTranslationId;
    }

    @Basic
    @Column(name = "NewsId")
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "TileTranslation")
    public String getTileTranslation() {
        return tileTranslation;
    }

    public void setTileTranslation(String tileTranslation) {
        this.tileTranslation = tileTranslation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblDesTileTranslationEntity that = (TblDesTileTranslationEntity) o;

        if (tileTranslationId != that.tileTranslationId) return false;
        if (newsId != that.newsId) return false;
        if (tileTranslation != null ? !tileTranslation.equals(that.tileTranslation) : that.tileTranslation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tileTranslationId;
        result = 31 * result + newsId;
        result = 31 * result + (tileTranslation != null ? tileTranslation.hashCode() : 0);
        return result;
    }
}
