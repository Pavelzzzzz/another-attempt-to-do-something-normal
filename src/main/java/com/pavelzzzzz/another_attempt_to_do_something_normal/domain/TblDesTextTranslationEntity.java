package com.pavelzzzzz.another_attempt_to_do_something_normal.domain;

import javax.persistence.*;

@Entity
@Table(name = "tblDESTextTranslation", schema = "news_blog", catalog = "")
public class TblDesTextTranslationEntity {
    private int textId;
    private String textTranslation;

    @Id
    @Column(name = "TextId")
    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    @Basic
    @Column(name = "TextTranslation")
    public String getTextTranslation() {
        return textTranslation;
    }

    public void setTextTranslation(String textTranslation) {
        this.textTranslation = textTranslation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblDesTextTranslationEntity that = (TblDesTextTranslationEntity) o;

        if (textId != that.textId) return false;
        if (textTranslation != null ? !textTranslation.equals(that.textTranslation) : that.textTranslation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = textId;
        result = 31 * result + (textTranslation != null ? textTranslation.hashCode() : 0);
        return result;
    }
}
