package com.example.blog.model.service;

import com.example.blog.model.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

   Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

}
