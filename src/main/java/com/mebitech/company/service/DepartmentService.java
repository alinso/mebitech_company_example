package com.mebitech.company.service;
import com.mebitech.company.dao.IGenericDAO;
import com.mebitech.company.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {


    IGenericDAO< Department > dao;

    @Autowired
    public void setDao( IGenericDAO< Department > daoToSet ){
        dao = daoToSet;
        dao.setClazz( Department.class );
    }

    @Override
    public Department get(Integer id) {

        Department d = dao.get(id);
        if(d==null)
            d = new Department();
        return d;
    }

    @Override
    public List<Department> getAll() {
        return dao.getAll();
    }

    @Override
    public void saveOrUpdate(Department d){
        dao.saveOrUpdate(d);
    }

    @Override
    public void deleteById(Integer id) {
        dao.delete(id);
    }

    public Department getFirst(){
        List<Department> departments  =getAll();
       Department d = departments.get(0);
       return d;
    }
}
