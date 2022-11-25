package com.digipay.usermanagement.model.entity;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "role")
public class Role extends BaseEntity{

    @Column(name = "role_title")
    private String title;


    @OneToMany
    @JoinColumn(name = "role_id")
    private List<User> users;


    @ManyToMany
    @JoinTable(
            name = "role_permission",
            joinColumns = @JoinColumn(name = "role_ID"),
            inverseJoinColumns = @JoinColumn(name = "permission_ID"))
    private List<Permission> permission;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Permission> getPermission() {
        return permission;
    }

    public void setPermission(List<Permission> permission) {
        this.permission = permission;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return this.getId() + " -> " + this.title;
    }
}
