package com.codegym.model.service.impl;

import com.codegym.model.entity.Province;
import com.codegym.model.repository.IProvinceRepository;
import com.codegym.model.service.IProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceService implements IProvinceService {
    @Autowired
    private IProvinceRepository iProvinceRepository;

    @Override
    public List<Province> findAll() {
        return this.iProvinceRepository.findAll();
    }

    @Override
    public void save(Province province) {
        iProvinceRepository.save(province);
    }

    @Override
    public void remove(Integer id) {
        iProvinceRepository.deleteById(id);

    }

    @Override
    public Province findById(Integer id) {
        return iProvinceRepository.findById(id).orElse(null);
    }
}
