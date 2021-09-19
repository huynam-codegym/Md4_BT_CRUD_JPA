package com.huynam.service;

import com.huynam.model.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    void save(Employee employee);
    void delete(Long id);
    Employee findById(Long id);
}
