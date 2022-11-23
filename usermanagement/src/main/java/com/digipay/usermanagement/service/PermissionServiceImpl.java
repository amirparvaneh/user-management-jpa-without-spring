package com.digipay.usermanagement.service;

import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.repository.PermissionRepository;

import java.util.List;
import java.util.Optional;

public class PermissionServiceImpl implements PermissionCrud {

    @Override
    public void save(Permission permission) {
        PermissionRepository permissionRepository = new PermissionRepository();
        permissionRepository.save(permission);
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
        PermissionRepository permissionRepository = new PermissionRepository();
        List<Permission> all = permissionRepository.findAll();
        return all;
    }

    @Override
    public void deleteById(Long id) {

    }
}
