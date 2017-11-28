package com.mebitech.company.service;

import com.mebitech.company.dao.EmployeeDAO;
import com.mebitech.company.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{



    @Autowired
    EmployeeDAO dao;

    @Override
    public Employee findOne(Integer id) {
        return null;
    }

    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override
    public void create(Employee e) {

    }

    @Override
    public Employee update(Employee e) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
