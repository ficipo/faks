package com.faks.faks.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name="role_id")
    private Role role;

}
