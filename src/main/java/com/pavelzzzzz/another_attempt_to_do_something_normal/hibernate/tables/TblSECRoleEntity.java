package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tblSECRole", schema = "news_blog")
public class TblSECRoleEntity{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int roleId;
    @NotBlank
    private String role;

    @ManyToMany
    @JoinTable(name = "tblSECUserRole",
    joinColumns = @JoinColumn(name = "RoleId"),
    inverseJoinColumns = @JoinColumn(name = "UserId"))
    private List<TblSECUserEntity> listUserEntity;

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<TblSECUserEntity> getListUserEntity() {
        return listUserEntity;
    }

    public void setListUserEntity(
        List<TblSECUserEntity> listUserEntity) {
        this.listUserEntity = listUserEntity;
    }
}
