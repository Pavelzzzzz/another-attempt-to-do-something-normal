package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tblDESTitleTranslation", schema = "news_blog")
public class TblDESTitleTranslationEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int titleTranslationId;
    @NotBlank
    private String titleTranslation;
    @NotBlank
    @ManyToOne(optional = false,
            //    mappedBy = "tblSERLanguageEntity",
            cascade = CascadeType.ALL)
    @JoinColumn(name = "LanguageId")
    private TblSERLanguageEntity tblSERLanguageEntity;
    @NotBlank
    @ManyToOne(optional = false,
            //    mappedBy = "tblSERLanguageEntity",
            cascade = CascadeType.ALL)
    @JoinColumn(name = "NewsId")
    private TblAPLNewsEntity tblAPLNewsEntity;

    public int getTitleTranslationId() {
        return titleTranslationId;
    }

    public void setTitleTranslationId(int titleTranslationId) {
        this.titleTranslationId = titleTranslationId;
    }

    public String getTitleTranslation() {
        return titleTranslation;
    }

    public void setTitleTranslation(String titleTranslation) {
        this.titleTranslation = titleTranslation;
    }

    public TblSERLanguageEntity getTblSERLanguageEntity() {
        return tblSERLanguageEntity;
    }

    public void setTblSERLanguageEntity(TblSERLanguageEntity tblSERLanguageEntity) {
        this.tblSERLanguageEntity = tblSERLanguageEntity;
    }

    public TblAPLNewsEntity getTblAPLNewsEntity() {
        return tblAPLNewsEntity;
    }

    public void setTblAPLNewsEntity(TblAPLNewsEntity tblAPLNewsEntity) {
        this.tblAPLNewsEntity = tblAPLNewsEntity;
    }
}
