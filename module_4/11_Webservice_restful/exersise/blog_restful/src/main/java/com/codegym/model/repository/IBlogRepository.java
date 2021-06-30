package com.codegym.model.repository;


import com.codegym.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
//    @Query(value = "select * from blog where `name` like :keywordParam ", nativeQuery =true)
//    Page<Blog> getBlogBySearchingName(Pageable pageable, @Param("keywordParam") String keyword);
    Page<Blog> findAllByNameContaining(Pageable pageable, String keyword);
}
