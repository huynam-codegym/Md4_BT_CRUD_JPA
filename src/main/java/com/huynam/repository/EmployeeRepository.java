package com.huynam.repository;

import com.huynam.model.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class EmployeeRepository implements IEmployeeRepository{

    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Employee> findAll() {
        String queryStr = "select  c from Employee as c";
        List<Employee> employeeList = entityManager.createQuery(queryStr, Employee.class ).getResultList();

        return employeeList;
    }

    @Override
    public void save(Employee employee) {
        if(employee!=null){
            entityManager.merge(employee);
        } else {
            entityManager.persist(employee);
        }
    }

    @Override
    public void delete(Long id) {
        Employee employee = findById(id);
        if(employee!=null){
            entityManager.remove(employee);
        }
    }

    @Override
    public Employee findById(Long id) {
        String queryStr = "select c from Employee as c where c.id =:id";
        Employee employee = entityManager.createQuery(queryStr,Employee.class).setParameter("id",id).getSingleResult();
        return employee;
    }
}
