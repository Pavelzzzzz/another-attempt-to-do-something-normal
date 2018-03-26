package com.pavelzzzzz.another_attempt_to_do_something_normal.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "tblSECPassword")
public class TblSECPasswordEntity {

    @OneToOne(optional = false,
        mappedBy = "TblSECUserEntity",
        cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
    private TblSECUserEntity tblSECUserEntity;
    @NotBlank
    private String password;
}
