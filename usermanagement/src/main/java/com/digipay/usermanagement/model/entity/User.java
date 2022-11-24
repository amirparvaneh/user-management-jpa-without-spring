package com.digipay.usermanagement.model.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "user")
public class User extends BaseEntity {


    private String name;

    private Long nationalID;

    private Role role;

    public User() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "national_ID")
    public Long getNationalID() {
        return nationalID;
    }

    public void setNationalID(Long nationalID) {
        this.nationalID = nationalID;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
