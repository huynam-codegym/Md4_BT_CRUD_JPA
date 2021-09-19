package com.huynam.service;

import com.huynam.model.Employee;
import com.huynam.repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{
@Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
employeeRepository.delete(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id);
    }
}
