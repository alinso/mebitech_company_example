package com.mebitech.company.service;

import com.mebitech.company.entity.Employee;

import java.util.List;

public interface IEmployeeService {


    public Employee get(Integer id);

    List<Employee> getAll();

    void create(Employee e);

    Employee update(Employee e);

    void deleteById(Integer id);
}
