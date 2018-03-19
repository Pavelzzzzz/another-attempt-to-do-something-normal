package com.pavelzzzzz.another_attempt_to_do_something_normal.entity;

import javax.persistence.*;

@Entity
@Table(name = "tblSERLanguage", schema = "news_blog", catalog = "")
public class TblSerLanguageEntity {
    private int languageId;
    private String isoCode;

    @Id
    @Column(name = "LanguageId")
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "ISOCode")
    public String getIsoCode() {
        return isoCode;
    }

    public void setIsoCode(String isoCode) {
        this.isoCode = isoCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblSerLanguageEntity that = (TblSerLanguageEntity) o;

        if (languageId != that.languageId) return false;
        if (isoCode != null ? !isoCode.equals(that.isoCode) : that.isoCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = languageId;
        result = 31 * result + (isoCode != null ? isoCode.hashCode() : 0);
        return result;
    }
}
