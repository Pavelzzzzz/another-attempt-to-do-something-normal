package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tblAPLCategory", schema = "news_blog")
public class TblAPLCategoryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int categoryId;
    @NotBlank
    private String categoryName;

    public TblAPLCategoryEntity() {
    }

    public TblAPLCategoryEntity(@NotBlank String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
