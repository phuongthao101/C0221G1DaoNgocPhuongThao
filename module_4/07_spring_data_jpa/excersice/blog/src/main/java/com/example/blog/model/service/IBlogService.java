package com.example.blog.model.service;

import com.example.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

//    Page<Blog> findAllSearchName(Pageable pageable, String keyword);

    Page<Blog> findAllByNameContaining(Pageable pageable, String keyword);
}
