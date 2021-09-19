package com.huynam.repository;

import com.huynam.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IEmployeeRepository {

    List<Employee> findAll();
    void save(Employee employee);
    void delete(Long id);
    Employee findById(Long id);
}
