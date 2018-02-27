package com.pavelzzzzz.another_attempt_to_do_something_normal.domain;

import javax.persistence.*;

@Entity
@Table(name = "tblSECPassword", schema = "news_blog", catalog = "")
public class TblSecPasswordEntity {
    private int userId;
    private String password;

    @Id
    @Column(name = "UserId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "Password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblSecPasswordEntity that = (TblSecPasswordEntity) o;

        if (userId != that.userId) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
