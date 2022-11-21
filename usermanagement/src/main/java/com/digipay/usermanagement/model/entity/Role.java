package com.digipay.usermanagement.model.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "role")
public class Role extends BaseEntity{

    @Column(name = "role_title")
    private String title;

    public Role() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
