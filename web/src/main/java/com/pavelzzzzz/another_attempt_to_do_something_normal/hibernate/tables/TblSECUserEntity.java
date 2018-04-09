package com.pavelzzzzz.another_attempt_to_do_something_normal.hibernate.tables;

import java.util.Collection;
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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "tblSECUser")
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
    @OneToOne(mappedBy = "tblSECUserEntity", fetch = FetchType.EAGER)
    private TblSECPasswordEntity tblSECPasswordEntity;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "tblSECUserRole",
        joinColumns = @JoinColumn(name = "UserId"),
        inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private List<TblSECRoleEntity> listRoleEntity;

}
