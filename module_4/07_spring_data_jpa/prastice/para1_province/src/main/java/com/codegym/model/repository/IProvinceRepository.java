package com.codegym.model.repository;

import com.codegym.model.entity.Customer;
import com.codegym.model.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProvinceRepository extends JpaRepository<Province, Integer> {


}
