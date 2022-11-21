package com.digipay.usermanagement.service;

import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.repository.PermissionRepoCrud;

import java.util.List;
import java.util.Optional;

public class PermissionCrudImpl implements PermissionCrud {

    @Override
    public void save(Permission permission) {
        PermissionRepoCrud permissionRepoCrud = new PermissionRepoCrud();
        permissionRepoCrud.save(permission);
    }

    @Override
    public String delete(Long id) {
        return null;
    }

    @Override
    public Optional<Permission> update(Long id, Permission permission) {
        return Optional.empty();
    }

    @Override
    public List<Permission> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
