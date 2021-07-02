package com.example.ex_home.model.service;

import com.example.ex_home.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> findByAll(Pageable pageable);

    Page<Product> findByName(String name, Pageable pageable);

    void save(Product product);

    void remove(Long id);

    Product findById(Long id);

}
