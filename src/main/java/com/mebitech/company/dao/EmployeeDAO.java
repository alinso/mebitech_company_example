package com.mebitech.company.dao;

import com.mebitech.company.entity.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO extends AbstractHibernateDAO {

    public EmployeeDAO() {
        setClazz(Employee.class );
    }
}
