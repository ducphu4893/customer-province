package com.codegym.customerprovince.service;

import com.codegym.customerprovince.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    Page<User> findAll(Pageable pageable);

    User findById(int id);

    void save(User user);

    void remove(int id);

    Page<User> findAllByFirstNameContaining(String fisrtname,Pageable pageable);
}
