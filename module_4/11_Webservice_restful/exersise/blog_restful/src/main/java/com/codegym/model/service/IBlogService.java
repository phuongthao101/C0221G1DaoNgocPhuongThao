package com.codegym.model.service;


import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Long id);

    void save(Blog blog);

    void remove(Long id);

//    Page<Blog> findAllSearchName(Pageable pageable, String keyword);

    Page<Blog> findAllByNameContaining(Pageable pageable, String keyword);
}
