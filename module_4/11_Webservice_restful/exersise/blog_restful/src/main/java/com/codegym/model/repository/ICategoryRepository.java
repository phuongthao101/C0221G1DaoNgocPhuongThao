package com.codegym.model.repository;


import com.codegym.model.entity.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
//    Iterable<Blog> findAllByCategory(Category category);
}