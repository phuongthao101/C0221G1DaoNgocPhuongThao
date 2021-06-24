package com.example.blog.model.service.impl;

import com.example.blog.model.entity.Blog;
import com.example.blog.model.repository.IBlogRepository;
import com.example.blog.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }


    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAllByNameContaining(Pageable pageable, String keyword) {
        return this.iBlogRepository.findAllByNameContaining(pageable,keyword);
    }

//    @Override
//    public Page<Blog> findAllSearchName(Pageable pageable, String keyword) {
//        return this.iBlogRepository.getBlogBySearchingName(pageable,"%"+keyword+"%");
//    }


}
