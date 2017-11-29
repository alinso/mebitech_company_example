package com.mebitech.company.dao;

import com.mebitech.company.entity.Department;

import java.util.List;

public interface IDepartmentDAO {
    public void saveOrUpdate(Department e);
    public Department get(Integer id);
    public List<Department> getAll();
    public void delete(Integer id);
}
