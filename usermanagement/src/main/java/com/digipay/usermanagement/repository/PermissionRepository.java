package com.digipay.usermanagement.repository;

import com.digipay.usermanagement.JPAUtil;
import com.digipay.usermanagement.model.entity.Permission;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;

import java.util.List;
import java.util.Optional;

public class PermissionRepository implements PermissionRepo {

    @Override
    public void save(Permission permission) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(permission);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new HibernateException(e.getMessage());
        } finally {
            entityManager.close();
        }
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
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        Query query = entityManager.createQuery("select per from Permission per");
        List resultList = query.getResultList();
        return resultList;
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
