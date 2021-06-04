package model.service;

import model.bean.employee.Division;
import model.bean.employee.EducationDegree;
import model.bean.employee.Employee;
import model.bean.employee.Position;

import java.util.List;

public interface IEmploymentService {
    List<Employee> findAllEmployee();

    List<Position> findAllPosition();

    List<EducationDegree> findAllEducation();

    List<Division> findAllDivision();

    boolean create(Employee employee);

    public boolean remove(int id);

    List<Employee> findByName(String name);
}
