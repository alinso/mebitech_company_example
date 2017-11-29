package com.mebitech.company.service;

import com.mebitech.company.dao.IEmployeeDAO;
import com.mebitech.company.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService{


    @Autowired
    IEmployeeDAO dao;


    @Override
    public Employee get(Integer id) {
        return  dao.get(id);
    }

    @Override
    public List<Employee> getAll() {
        return dao.getAll();
    }


    @Override
    public void saveOrUpdate(Employee e) {
        dao.saveOrUpdate(e);

    }

    @Override
    public void deleteById(Integer id) {
        dao.delete(id);
    }
}
