package com.digipay.usermanagement.model.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "permission")
public class Permission extends BaseEntity {

    @Column(name = "permission_title")
    private String title;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
