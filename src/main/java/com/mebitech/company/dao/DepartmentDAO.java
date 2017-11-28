package com.mebitech.company.dao;

import com.mebitech.company.entity.Department;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public class DepartmentDAO implements IDepartmentDAO{
    @Autowired
    SessionFactory sessionFactory;


    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void saveOrUpdate(Department e) {
        getCurrentSession().saveOrUpdate(e);
    }

    @Transactional
    public Department get(Integer id) {
        return  getCurrentSession().get( Department.class, id );
    }

    @Transactional
    public List<Department> getAll() {
        return getCurrentSession().createQuery( "from Department" ).list();
    }

    @Transactional
    public void delete(Department e) {
        getCurrentSession().delete(e);

    }

}
