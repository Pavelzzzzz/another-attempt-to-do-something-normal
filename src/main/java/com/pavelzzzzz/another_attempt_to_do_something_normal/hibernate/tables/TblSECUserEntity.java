package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import java.util.List;
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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private boolean enabled;
    @OneToOne(mappedBy = "tblSECUserEntity", fetch = FetchType.LAZY)
    private TblSECPasswordEntity tblSECPasswordEntity;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tblSECUserRole",
        joinColumns = @JoinColumn(name = "UserId"),
        inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private List<TblSECRoleEntity> listRoleEntity;

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
