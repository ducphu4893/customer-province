package com.codegym.customerprovince.service.impl;

import com.codegym.customerprovince.model.Province;
import com.codegym.customerprovince.repository.ProvinceRepository;
import com.codegym.customerprovince.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAall() {
        return provinceRepository.findAll();
    }

    @Override
    public Province findById(int id) {
        return provinceRepository.findById(id).get();
    }

    @Override
    public void save(Province province) {
        provinceRepository.save(province);
    }

    @Override
    public void remove(int id) {
        provinceRepository.deleteById(id);
    }
}
