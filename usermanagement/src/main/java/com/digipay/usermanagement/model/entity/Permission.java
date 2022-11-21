package com.digipay.usermanagement.model.entity;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "permission")
public class Permission extends BaseEntity {

    @Column(name = "permission_title")
    private String title;

    //    @ManyToMany
//    @JoinTable(name = "UMPERROL",joinColumns = {
//            @JoinColumn(name = "permission_id",nullable = false)},inverseJoinColumns = {
//            @JoinColumn(name = "role_id",nullable = false)
//    })
    @ManyToMany
    @JoinTable(
            name = "permission_role",
            joinColumns = @JoinColumn(name = "permission"),
            inverseJoinColumns = @JoinColumn(name = "role"))
    private List<Role> roles;

    public Permission() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
