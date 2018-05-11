package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import java.sql.Timestamp;
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
@Table(name = "tblAPLNews", schema = "news_blog")
public class TblAPLNewsEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int newsId;
//    @NotBlank
    @ManyToOne(optional = false,
            //    mappedBy = "tblSERLanguageEntity",
            cascade = CascadeType.ALL)
    @JoinColumn(name = "CategoryId")
    private TblAPLCategoryEntity tblAPICategoryEntity;
    private Timestamp createdAt;
    private Timestamp updatedAt;
//    @NotBlank
    @ManyToOne(optional = false,
            cascade = CascadeType.ALL)
    @JoinColumn(name = "CreatedBy")
    private TblSECUserEntity tblSECUserEntity;
//    @NotBlank
    private int titleId;
//    @NotBlank
    private String htmlArchitecture;

    public TblAPLNewsEntity() {
    }

    public TblAPLNewsEntity(
        @NotBlank TblAPLCategoryEntity tblAPICategoryEntity,
        @NotBlank TblSECUserEntity tblSECUserEntity,
        @NotBlank int titleId,
        @NotBlank String htmlArchitecture) {
        this.tblAPICategoryEntity = tblAPICategoryEntity;
        this.tblSECUserEntity = tblSECUserEntity;
        this.titleId = titleId;
        this.htmlArchitecture = htmlArchitecture;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public TblAPLCategoryEntity getTblAPICategoryEntity() {
        return tblAPICategoryEntity;
    }

    public void setTblAPICategoryEntity(TblAPLCategoryEntity tblAPICategoryEntity) {
        this.tblAPICategoryEntity = tblAPICategoryEntity;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public TblSECUserEntity getTblSECUserEntity() {
        return tblSECUserEntity;
    }

    public void setTblSECUserEntity(TblSECUserEntity tblSECUserEntity) {
        this.tblSECUserEntity = tblSECUserEntity;
    }

    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    public String getHtmlArchitecture() {
        return htmlArchitecture;
    }

    public void setHtmlArchitecture(String htmlArchitecture) {
        this.htmlArchitecture = htmlArchitecture;
    }
}
