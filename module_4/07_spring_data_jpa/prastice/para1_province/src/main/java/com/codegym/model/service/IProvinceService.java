package com.codegym.model.service;

import com.codegym.model.entity.Province;

import java.util.List;

public interface IProvinceService {
    List<Province> findAll();

    void save(Province province);

    void remove(Integer id);

    Province findById(Integer id);

}
