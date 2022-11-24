package com.digipay.usermanagement.model.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "user")
public class User extends BaseEntity {


    private String name;

    private Long nationalID;


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

}
