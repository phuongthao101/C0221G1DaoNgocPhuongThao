package com.codygym.model.repository.service;

import com.codygym.model.entity.service.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServiceRepository extends JpaRepository<Services, Long> {
}
