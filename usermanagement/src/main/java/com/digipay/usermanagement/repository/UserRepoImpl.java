package com.digipay.usermanagement.repository;

import com.digipay.usermanagement.JPAUtil;
import com.digipay.usermanagement.model.entity.Role;
import com.digipay.usermanagement.model.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.HibernateException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepoImpl implements UserRepo {


    @Override
    public void save(User user) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public String delete(Long id) {
        deleteById(id);
        String resultMessage = "User with this Id " + id + "have been deleted";
        return resultMessage;
    }

    @Override
    public Optional<User> update(Long id, User user) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            List<User> users = new ArrayList<>();
            Query query = entityManager.createQuery("select user from User user");
            users = query.getResultList();
            return users;
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
            User user = findById(id);
            entityManager.remove(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            throw new HibernateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    @Override
    public User findById(Long id) {
        EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
        try {
            Query query = entityManager.createQuery("select user from User user where user.id = :id")
                    .setParameter("id", id);
            User user = (User) query.getSingleResult();
            return user;
        } catch (Exception e) {
            throw new HibernateException(e.getMessage());
        } finally {
            entityManager.close();
        }
    }
}
