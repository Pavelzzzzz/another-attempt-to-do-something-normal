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
@Table(name = "tblDESTileTranslation", schema = "news_blog")
public class TblDesTileTranslationEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int tileTranslationId;
    @NotBlank
    private String tileTranslation;
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

    public int getTileTranslationId() {
        return tileTranslationId;
    }

    public void setTileTranslationId(int tileTranslationId) {
        this.tileTranslationId = tileTranslationId;
    }

    public String getTileTranslation() {
        return tileTranslation;
    }

    public void setTileTranslation(String tileTranslation) {
        this.tileTranslation = tileTranslation;
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
