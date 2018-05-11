package com.pavelzzzzz.another_attempt_to_do_something_normal.service.entity;

import java.sql.Timestamp;
import javax.validation.constraints.NotBlank;

public class News {

    @NotBlank
    private int newsId;
    @NotBlank
    private Language language;
    @NotBlank
    private Category category;
    @NotBlank
    private Timestamp createdAt;
    private Timestamp updatedAt;
    @NotBlank
    private User createdBy;
    @NotBlank
    private String title;
    @NotBlank
    private String htmlArchitecture;

    public News() {
    }

    public News(@NotBlank int newsId,
        @NotBlank Language language,
        @NotBlank Category category,
        @NotBlank Timestamp createdAt,
        Timestamp updatedAt,
        @NotBlank User createdBy,
        @NotBlank String title,
        @NotBlank String htmlArchitecture) {
        this.newsId = newsId;
        this.language = language;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.title = title;
        this.htmlArchitecture = htmlArchitecture;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(
        Language language) {
        this.language = language;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(
        Category category) {
        this.category = category;
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

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(
        User createdBy) {
        this.createdBy = createdBy;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHtmlArchitecture() {
        return htmlArchitecture;
    }

    public void setHtmlArchitecture(String htmlArchitecture) {
        this.htmlArchitecture = htmlArchitecture;
    }
}
