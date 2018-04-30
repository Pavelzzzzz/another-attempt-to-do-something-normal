package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tblSECPassword")
public class TblSECPasswordEntity {

    @Id
    private int userId;

    @OneToOne(optional = false,
    //    mappedBy = "tblSECUserEntity",
        cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
    private TblSECUserEntity tblSECUserEntity;
    @NotBlank
    private String password;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TblSECUserEntity getTblSECUserEntity() {
        return tblSECUserEntity;
    }

    public void setTblSECUserEntity(
        TblSECUserEntity tblSECUserEntity) {
        this.tblSECUserEntity = tblSECUserEntity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}