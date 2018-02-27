package com.pavelzzzzz.another_attempt_to_do_something_normal.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "tblAPLNews", schema = "news_blog", catalog = "")
public class TblAplNewsEntity {
    private int newsId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private int createdBy;
    private String xmlArchitecture;

    @Id
    @Column(name = "NewsId")
    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    @Basic
    @Column(name = "CreatedAt")
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "UpdatedAt")
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "CreatedBy")
    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "XMLArchitecture")
    public String getXmlArchitecture() {
        return xmlArchitecture;
    }

    public void setXmlArchitecture(String xmlArchitecture) {
        this.xmlArchitecture = xmlArchitecture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblAplNewsEntity that = (TblAplNewsEntity) o;

        if (newsId != that.newsId) return false;
        if (createdBy != that.createdBy) return false;
        if (createdAt != null ? !createdAt.equals(that.createdAt) : that.createdAt != null) return false;
        if (updatedAt != null ? !updatedAt.equals(that.updatedAt) : that.updatedAt != null) return false;
        if (xmlArchitecture != null ? !xmlArchitecture.equals(that.xmlArchitecture) : that.xmlArchitecture != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = newsId;
        result = 31 * result + (createdAt != null ? createdAt.hashCode() : 0);
        result = 31 * result + (updatedAt != null ? updatedAt.hashCode() : 0);
        result = 31 * result + createdBy;
        result = 31 * result + (xmlArchitecture != null ? xmlArchitecture.hashCode() : 0);
        return result;
    }
}
