package com.mebitech.company.dao;

import com.mebitech.company.entity.Employee;

import java.util.List;

public interface IEmployeeDAO {

    public void saveOrUpdate(Employee e);
    public Employee get(Integer id);
    public List<Employee> getAll();
    public void delete(Integer id);
}
