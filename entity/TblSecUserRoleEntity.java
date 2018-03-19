package com.pavelzzzzz.another_attempt_to_do_something_normal.entity;

import javax.persistence.*;

@Entity
@Table(name = "tblSECUserRole", schema = "news_blog", catalog = "")
@IdClass(TblSecUserRoleEntityPK.class)
public class TblSecUserRoleEntity {
    private int userId;
    private int roleId;

    @Id
    @Column(name = "UserId")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "RoleId")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblSecUserRoleEntity that = (TblSecUserRoleEntity) o;

        if (userId != that.userId) return false;
        if (roleId != that.roleId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + roleId;
        return result;
    }
}
