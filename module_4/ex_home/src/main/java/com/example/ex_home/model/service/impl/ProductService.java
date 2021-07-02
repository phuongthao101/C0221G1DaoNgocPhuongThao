package com.example.ex_home.model.service.impl;

import com.example.ex_home.model.entity.Product;
import com.example.ex_home.model.repository.IProductRepository;
import com.example.ex_home.model.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Page<Product> findByAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return productRepository.findByName(name,pageable);
    }

    @Override
    public void save(Product product) {
productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
productRepository.deleteById(id);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
