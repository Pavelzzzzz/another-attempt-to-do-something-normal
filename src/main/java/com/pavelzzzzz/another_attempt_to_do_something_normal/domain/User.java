package com.pavelzzzzz.another_attempt_to_do_something_normal.domain;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tblSECUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long UserId;

    @NotBlank
    @Column(name = "Username", unique = true)
    @Size(min = 1, max = 100)
    private String username;

    @Column(name = "Email")
    @Size(max = 256)
    private String email;

    @NotBlank
    @Column(name = "IsActive", columnDefinition = "boolean default 0")
    private boolean isActive;
}
