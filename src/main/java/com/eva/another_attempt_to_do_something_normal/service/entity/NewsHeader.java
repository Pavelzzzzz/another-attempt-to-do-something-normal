package com.eva.another_attempt_to_do_something_normal.service.entity;

import java.sql.Timestamp;
import javax.validation.constraints.NotBlank;

public class NewsHeader {

    @NotBlank
    private int newsId;
    @NotBlank
    private Language language;
    @NotBlank
    private Category category;
    @NotBlank
    private Timestamp createdAt;
    @NotBlank
    private Timestamp updatedAt;
    @NotBlank
    private User createdBy;
    @NotBlank
    private String title;

    public NewsHeader() {
    }

    public NewsHeader(@NotBlank int newsId,
                @NotBlank Language language,
                @NotBlank Category category,
                @NotBlank Timestamp createdAt,
                @NotBlank Timestamp updatedAt,
                @NotBlank User createdBy,
                @NotBlank String title) {
        this.newsId = newsId;
        this.language = language;
        this.category = category;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.title = title;
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
}
