package com.digipay.usermanagement.service;

import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.repository.PermissionRepository;

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
        PermissionRepository permissionRepository = new PermissionRepository();
        permissionRepository.save(permission);
    }

    @Override
    public String delete(Long id) {
        PermissionRepository permissionRepository = new PermissionRepository();
        permissionRepository.deleteById(id);
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
        PermissionRepository permissionRepository = new PermissionRepository();
        List<Permission> all = permissionRepository.findAll();
        return all;
    }

    @Override
    public void deleteById(Long id) {
        PermissionRepository permissionRepository = new PermissionRepository();
        permissionRepository.deleteById(id);
    }

    @Override
    public Permission findById(Long id) {
        Permission permission = new Permission();
        PermissionRepository permissionRepository = new PermissionRepository();
        permission = permissionRepository.findById(id);
        return permission;
    }
}
