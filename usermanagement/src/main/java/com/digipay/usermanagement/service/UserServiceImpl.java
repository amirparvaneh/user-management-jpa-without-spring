package com.digipay.usermanagement.service;

import com.digipay.usermanagement.model.entity.User;
import com.digipay.usermanagement.repository.UserRepoImpl;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserCrud{

    private UserRepoImpl userRepo;

    public UserServiceImpl(UserRepoImpl userRepo){
        this.userRepo = userRepo;
    }

    @Override
    public void save(User user) {
        //UserRepoImpl userRepo = new UserRepoImpl();
        userRepo.save(user);
    }

    @Override
    public String delete(Long id) {

        return null;
    }

    @Override
    public Optional<User> update(Long id, User user) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
