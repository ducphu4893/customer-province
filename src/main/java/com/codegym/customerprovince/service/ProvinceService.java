package com.codegym.customerprovince.service;

import com.codegym.customerprovince.model.Province;

public interface ProvinceService {
    Iterable<Province> findAall();

    Province findById(int id);

    void save(Province province);

    void remove(int id);

}
