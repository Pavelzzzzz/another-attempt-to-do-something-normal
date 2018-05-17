package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tblSECPassword", schema = "news_blog")
public class TblSECPasswordEntity {

    @Id
    private int userId;

    @NotNull
    @OneToOne(optional = false,
            //    mappedBy = "tblSECUserEntity",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JoinColumn(name = "UserId")
    @MapsId
    private TblSECUserEntity tblSECUserEntity;
    @NotBlank
    private String password;

    public TblSECPasswordEntity() {
    }

    public TblSECPasswordEntity(
        @NotBlank String password) {
        this.password = password;
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
