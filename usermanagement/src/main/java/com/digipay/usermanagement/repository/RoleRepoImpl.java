package com.digipay.usermanagement.repository;

import com.digipay.usermanagement.JPAUtil;
import com.digipay.usermanagement.model.entity.Role;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.HibernateException;

import java.util.List;
import java.util.Optional;

public class RoleRepoImpl implements RoleRepo{

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
        return null;
    }

    @Override
    public Optional<Role> update(Long id, Role role) {
        return Optional.empty();
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
