package com.mebitech.company.dao;

import java.io.Serializable;
import java.util.List;

public interface IGenericDAO<T extends Serializable> {

    T get(final Integer id);

    List<T> getAll();

    void saveOrUpdate(final T entity);

    void delete(final Integer id);
    void setClazz(Class< T > clazzToSet);

}