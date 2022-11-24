package com.digipay.usermanagement.repository;

import com.digipay.usermanagement.JPAUtil;
import com.digipay.usermanagement.model.entity.Permission;
import com.digipay.usermanagement.service.PermissionServiceImpl;
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
        try {
            Query query = entityManager.createQuery("select per from Permission per");
            List resultList = query.getResultList();
            return resultList;
        } catch (Exception e) {
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        PermissionServiceImpl permissionService = new PermissionServiceImpl();
        try {
            Permission permission = new Permission();
            permission = permissionService.findById(id);

        }catch (Exception e){
            throw new HibernateException(e.getMessage());
        }
    }

    @Override
    public Permission findById(Long id) {
        Permission permission = new Permission();
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query query = entityManager.createQuery("select per from Permission per where per.id = :id ");
            permission = (Permission) query.setParameter("id", id).getSingleResult();
            return permission;
        } catch (Exception e) {
            throw new HibernateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }


}
