package com.digipay.usermanagement.repository;

import com.digipay.usermanagement.JPAUtil;
import com.digipay.usermanagement.model.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleRepoImpl implements RoleRepo {

    //public static final EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();

    @Override
    public void save(Role role) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(role);
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
        deleteById(id);
        String resultMessage = "role" + id + "have been deleted";
        return resultMessage;
    }

    @Override
    public Optional<Role> update(Long id, Role role) {
        return Optional.empty();
    }

    @Override
    public List<Role> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        List<Role> roles;
        try {
            Query query = entityManager.createQuery("select role from Role role");
            roles = query.getResultList();
            return roles;
        } catch (Exception e) {
            throw new HibernateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void deleteById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Role role = findById(id);
            entityManager.remove(role);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new HibernateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Role findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query query = entityManager.createQuery("select role from Role role where role.id = :id");
            Role role = (Role) query.setParameter("id", id).getSingleResult();
            return role;
        } catch (Exception e) {
            throw new HibernateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
