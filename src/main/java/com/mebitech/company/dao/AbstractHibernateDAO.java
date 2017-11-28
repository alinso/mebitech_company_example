package com.mebitech.company.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

public abstract class AbstractHibernateDAO< T extends Serializable> {

    private Class< T > clazz;

    @Autowired
    SessionFactory sessionFactory;



    public final void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }

    @Transactional
    public T findOne( Integer id ){
        return (T) getCurrentSession().get( clazz, id );
    }

    @Transactional
    public List< T > findAll(){
        return getCurrentSession().createQuery( "from " + clazz.getName() ).list();
    }
    @Transactional
    public void create( T entity ){
        getCurrentSession().persist( entity );
    }

    @Transactional
    public void update( T entity ){
        getCurrentSession().merge( entity );
    }

    @Transactional
    public void deleteById( Integer entityId ) {
        T entity = findOne( entityId );
        getCurrentSession().delete( entity );
    }

    public final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}