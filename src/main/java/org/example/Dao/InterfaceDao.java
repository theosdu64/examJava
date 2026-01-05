package org.example.Dao;

import java.util.List;

public interface InterfaceDao<T> {
    void save(T entity);
    T findById(Long id);
    List<T> findAll();
    void update(T entity);
    void delete(Long id);
}
