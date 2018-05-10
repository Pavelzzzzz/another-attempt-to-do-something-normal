package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tblDESTextTranslation", schema = "news_blog")
@IdClass(TblDESTextTranslationEntityPrimaryKeyTextIdLanguageId.class)
public class TblDESTextTranslationEntity {

    @Id
    @AttributeOverrides({
        @AttributeOverride(name = "textId",
            column = @Column(name="TextId")),
        @AttributeOverride(name = "languageId",
            column = @Column(name="LanguageId"))
    })

    @NotBlank
    private int textId;
    @NotBlank
    private int languageId;
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

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
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

