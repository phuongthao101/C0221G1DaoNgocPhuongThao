package com.example.blog.model.repository;

import com.example.blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
//    @Query(value = "select * from blog where `name` like :keywordParam ", nativeQuery =true)
//    Page<Blog> getBlogBySearchingName(Pageable pageable, @Param("keywordParam") String keyword);
    Page<Blog> findAllByNameContaining(Pageable pageable, String keyword);
}
