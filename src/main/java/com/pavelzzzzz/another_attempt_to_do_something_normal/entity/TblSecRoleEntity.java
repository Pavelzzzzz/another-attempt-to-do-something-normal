package com.pavelzzzzz.another_attempt_to_do_something_normal.entity;

import javax.persistence.*;

@Entity
@Table(name = "tblSECRole", schema = "news_blog", catalog = "")
public class TblSecRoleEntity {
    private int roleId;
    private String role;

    @Id
    @Column(name = "RoleId")
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "Role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TblSecRoleEntity that = (TblSecRoleEntity) o;

        if (roleId != that.roleId) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = roleId;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
