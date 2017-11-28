package com.mebitech.company.service;

import com.mebitech.company.dao.IGenericDAO;
import com.mebitech.company.entity.Employee;

import java.util.List;

public interface IEmployeeService {


    public Employee findOne(Integer id);

    List<Employee> findAll();

    void create(Employee e);

    Employee update(Employee e);

    void deleteById(Integer id);
}
