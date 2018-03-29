package com.pavelzzzzz.another_attempt_to_do_something_normal.entity;

import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
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
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@Table(name = "tblSECUser")
public class TblSECUserEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;
    @NotBlank
    private String username;
    @NotBlank
    private String email;
    @NotBlank
    private boolean enabled;

    @OneToOne(mappedBy = "tblSECUserEntity")
    private TblSECPasswordEntity tblSECPasswordEntity;
    @ManyToMany
    @JoinTable(name = "tblSECUserRole",
        joinColumns = @JoinColumn(name = "UserId"),
        inverseJoinColumns = @JoinColumn(name = "RoleId"))
    private List<TblSECRoleEntity> listRoleEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return listRoleEntity;
    }

    @Override
    public String getPassword() {
         return tblSECPasswordEntity.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }
}
