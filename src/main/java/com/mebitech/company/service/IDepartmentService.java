package com.mebitech.company.service;

import com.mebitech.company.entity.Department;

import java.util.List;

public interface IDepartmentService {
     Department get(Integer id);

     Department getFirst();

    List<Department> getAll();


    void saveOrUpdate(Department d);

    void deleteById(Integer id);
}
