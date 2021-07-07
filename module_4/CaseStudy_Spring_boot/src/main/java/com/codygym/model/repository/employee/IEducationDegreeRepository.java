package com.codygym.model.repository.employee;

import com.codygym.model.entity.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Long> {
}
