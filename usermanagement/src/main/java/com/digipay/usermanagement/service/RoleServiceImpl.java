package com.digipay.usermanagement.service;

import com.digipay.usermanagement.model.entity.Role;
import com.digipay.usermanagement.repository.RoleRepoImpl;

import java.util.List;
import java.util.Optional;

public class RoleServiceImpl implements RoleCrud{
    @Override
    public void save(Role role) {
        RoleRepoImpl roleRepo = new RoleRepoImpl();
        roleRepo.save(role);
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public Optional<Role> update(Long id, Role role) {
        return Optional.empty();
    }

    @Override
    public List<Role> findAll() {
        RoleRepoImpl roleRepo = new RoleRepoImpl();
        List<Role> roles = roleRepo.findAll();
        return roles;
    }

    @Override
    public void deleteById(Long id) {

    }
}
