package com.mebitech.company.service;

import com.mebitech.company.entity.Department;

import java.util.List;

public interface IDepartmentService {
    public Department get(Integer id);

    List<Department> getAll();

    void create(Department d);

    Department update(Department d);

    void deleteById(Integer id);
}
