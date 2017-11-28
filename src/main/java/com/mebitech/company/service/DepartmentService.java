package com.mebitech.company.service;

import com.mebitech.company.dao.IDepartmentDAO;
import com.mebitech.company.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {


    @Autowired
  IDepartmentDAO  dao;

    @Override
    public Department get(Integer id) {
        return null;
    }

    @Override
    public List<Department> getAll() {
        return dao.getAll();
    }

    @Override
    public void create(Department e) {

    }

    @Override
    public Department update(Department e) {
        return null;
    }

    @Override
    public void deleteById(Integer id) {

    }
}
