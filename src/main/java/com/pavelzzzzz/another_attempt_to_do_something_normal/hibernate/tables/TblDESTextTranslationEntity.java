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
@Table(name = "tblDESTextTranslation", schema = "news_blog")
public class TblDESTextTranslationEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int textId;
    @NotBlank
    private String textTranslation;
    @NotBlank
    @ManyToOne(optional = false,
            //    mappedBy = "tblSERLanguageEntity",
            cascade = CascadeType.ALL)
    @JoinColumn(name = "LanguageId")
    private TblSERLanguageEntity tblSERLanguageEntity;

    public int getTextId() {
        return textId;
    }

    public void setTextId(int textId) {
        this.textId = textId;
    }

    public String getTextTranslation() {
        return textTranslation;
    }

    public void setTextTranslation(String textTranslation) {
        this.textTranslation = textTranslation;
    }

    public TblSERLanguageEntity getTblSERLanguageEntity() {
        return tblSERLanguageEntity;
    }

    public void setTblSERLanguageEntity(TblSERLanguageEntity tblSERLanguageEntity) {
        this.tblSERLanguageEntity = tblSERLanguageEntity;
    }
}
