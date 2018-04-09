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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "tblSECRole")
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

}
