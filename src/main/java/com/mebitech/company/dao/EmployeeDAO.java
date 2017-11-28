package com.mebitech.company.dao;

import com.mebitech.company.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class EmployeeDAO implements IEmployeeDAO {


    @Autowired
    SessionFactory sessionFactory;


    public Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void saveOrUpdate(Employee e) {
        getCurrentSession().saveOrUpdate(e);
    }

    @Transactional
    public Employee get(Integer id) {
        return  getCurrentSession().get( Employee.class, id );
    }

    @Transactional
    public List<Employee> getAll() {
        return getCurrentSession().createQuery( "from Employee" ).list();
    }

    @Transactional
    public void delete(Employee e) {
        getCurrentSession().delete(e);

    }
}
