package com.pavelzzzzz.another_attempt_to_do_something_normal.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;

@Entity
@Getter
@EqualsAndHashCode
@Table(name = "tblSECUser")
public class TblSECUserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int userId;

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    private byte isActive;
}
