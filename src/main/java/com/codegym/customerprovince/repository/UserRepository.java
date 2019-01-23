package com.codegym.customerprovince.repository;

import com.codegym.customerprovince.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends PagingAndSortingRepository<User,Integer> {
    Page<User> findAllByFirstNameContaining(String firstname, Pageable pageable);
}
