package com.eva.another_attempt_to_do_something_normal.hibernate.tables;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tblSECUser", schema = "news_blog")
public class TblSECUserEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer userId;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    private boolean enabled;
    @OneToOne(mappedBy = "tblSECUserEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TblSECPasswordEntity tblSECPasswordEntity;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tblSECUserRole",
        joinColumns = @JoinColumn(name = "UserId"),
        inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private List<TblSECRoleEntity> listRoleEntity;

    public TblSECUserEntity() {
    }

    public TblSECUserEntity(
        @NotBlank String username,
        @NotBlank String email,
        boolean enabled,
        TblSECPasswordEntity tblSECPasswordEntity,
        List<TblSECRoleEntity> listRoleEntity) {
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.tblSECPasswordEntity = tblSECPasswordEntity;
        this.listRoleEntity = listRoleEntity;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public TblSECPasswordEntity getTblSECPasswordEntity() {
        return tblSECPasswordEntity;
    }

    public void setTblSECPasswordEntity(
        TblSECPasswordEntity tblSECPasswordEntity) {
        this.tblSECPasswordEntity = tblSECPasswordEntity;
    }

    public List<TblSECRoleEntity> getListRoleEntity() {
        return listRoleEntity;
    }

    public void setListRoleEntity(
        List<TblSECRoleEntity> listRoleEntity) {
        this.listRoleEntity = listRoleEntity;
    }
}
