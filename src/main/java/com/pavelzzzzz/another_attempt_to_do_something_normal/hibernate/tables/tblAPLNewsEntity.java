package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tblAPLNews", schema = "news_blog")
public class tblAPLNewsEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int newsId;
    @NotBlank
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @NotBlank
    private int createdBy;
    @NotBlank
    private String xmlArchitecture;

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
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

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getXmlArchitecture() {
        return xmlArchitecture;
    }

    public void setXmlArchitecture(String xmlArchitecture) {
        this.xmlArchitecture = xmlArchitecture;
    }
}
