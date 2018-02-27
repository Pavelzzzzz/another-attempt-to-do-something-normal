package com.pavelzzzzz.another_attempt_to_do_something_normal.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TblSecUserRoleEntityPK implements Serializable {
    private int userId;
    private int roleId;

    @Column(name = "UserId")
    @Id
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "RoleId")
    @Id
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

        TblSecUserRoleEntityPK that = (TblSecUserRoleEntityPK) o;

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
