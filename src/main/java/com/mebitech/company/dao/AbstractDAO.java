package com.mebitech.company.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractDAO< T extends Serializable> {

    private Class< T > clazz;

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public  void setClazz( Class< T > clazzToSet ){
        this.clazz = clazzToSet;
    }

    @Transactional
    public T get( Integer id ){

        T entity =   getCurrentSession().get( clazz, id );
        return entity;
    }

    @Transactional
    public List< T > getAll(){
        return getCurrentSession().createQuery( "from " + clazz.getName() ).list();
    }

    @Transactional
    public void saveOrUpdate( T entity ){
        getCurrentSession().saveOrUpdate( entity );
    }

    @Transactional
    public void delete( T entity ){
        getCurrentSession().delete( entity );
    }

    @Transactional
    public void delete( Integer entityId ) {
        T entity =get( entityId );
        delete( entity );
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}