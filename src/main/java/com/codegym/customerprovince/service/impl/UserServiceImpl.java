package com.codegym.customerprovince.service.impl;

import com.codegym.customerprovince.model.User;
import com.codegym.customerprovince.repository.UserRepository;
import com.codegym.customerprovince.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class UserServiceImpl implements UserService {
    @Autowired
    public UserRepository userRepository;

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public Page<User> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return userRepository.findAllByFirstNameContaining(firstname,pageable);
    }
}
