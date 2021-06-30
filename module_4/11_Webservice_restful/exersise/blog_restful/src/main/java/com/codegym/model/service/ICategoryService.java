package com.codegym.model.service;

import com.codegym.model.entity.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
   List<Category> findAll();

    Optional<Category> findById(Long id);

    void save(Category category);

    void remove(Long id);
}
