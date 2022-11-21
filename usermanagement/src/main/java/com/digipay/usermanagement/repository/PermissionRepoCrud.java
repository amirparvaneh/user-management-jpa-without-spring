package com.digipay.usermanagement.repository;

import com.digipay.usermanagement.model.entity.Permission;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Optional;

public class PermissionRepoCrud implements PermissionRepo{

    @Override
    public void save(Permission permission) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(permission);
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
//    public void save(Permission permission) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.persist(permission);
//    }
}
