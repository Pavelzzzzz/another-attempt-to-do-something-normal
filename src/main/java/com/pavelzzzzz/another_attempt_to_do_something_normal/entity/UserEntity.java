package com.pavelzzzzz.another_attempt_to_do_something_normal.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Table(name = "tblSECUser", schema = "news_blog", catalog = "")
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "UserId")
    private int userId;

    @NotBlank
    @Column(name = "Username")
    private String username;

    @NotBlank
    @Column(name = "Email")
    private String email;

    @NotBlank
    @Column(name = "IsActive")
    private byte isActive;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte getIsActive() {
        return isActive;
    }

    public void setIsActive(byte isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserEntity that = (UserEntity) o;

        if (userId != that.userId) return false;
        if (isActive != that.isActive) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) isActive;
        return result;
    }
}
