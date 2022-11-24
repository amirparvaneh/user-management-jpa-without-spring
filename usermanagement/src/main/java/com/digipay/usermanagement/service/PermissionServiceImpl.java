package com.digipay.usermanagement.service;

import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.repository.PermissionRepositoryImpl;

import java.util.List;
import java.util.Optional;

public class PermissionServiceImpl implements PermissionCrud {

//    private PermissionRepository permissionRepository;
//
//    public PermissionServiceImpl(PermissionRepository permissionRepository){
//        this.permissionRepository = permissionRepository;
//    }

    @Override
    public void save(Permission permission) {
        PermissionRepositoryImpl permissionRepositoryImpl = new PermissionRepositoryImpl();
        permissionRepositoryImpl.save(permission);
    }

    @Override
    public String delete(Long id) {
        PermissionRepositoryImpl permissionRepositoryImpl = new PermissionRepositoryImpl();
        permissionRepositoryImpl.deleteById(id);
        String resultMessage = id + " have been deleted";
        return resultMessage;
    }

    @Override
    public Optional<Permission> update(Long id, Permission permission) {
        Optional<Permission> permissionLast = Optional.of(new Permission());
        permissionLast = Optional.ofNullable(findById(id));
        permissionLast.get().setTitle(permission.getTitle());
        return permissionLast;
    }

    @Override
    public List<Permission> findAll() {
        PermissionRepositoryImpl permissionRepositoryImpl = new PermissionRepositoryImpl();
        List<Permission> all = permissionRepositoryImpl.findAll();
        return all;
    }

    @Override
    public void deleteById(Long id) {
        PermissionRepositoryImpl permissionRepositoryImpl = new PermissionRepositoryImpl();
        permissionRepositoryImpl.deleteById(id);
    }

    @Override
    public Permission findById(Long id) {
        Permission permission = new Permission();
        PermissionRepositoryImpl permissionRepositoryImpl = new PermissionRepositoryImpl();
        permission = permissionRepositoryImpl.findById(id);
        return permission;
    }
}
