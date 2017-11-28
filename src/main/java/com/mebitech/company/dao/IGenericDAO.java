package com.mebitech.company.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T extends Serializable> {

    void setClazz( Class< T > clazzToSet );

    T findOne( Integer id);

    List<T> findAll();

    void create( T entity);

    void update( T entity);

    void deleteById( Integer entityId);
}
