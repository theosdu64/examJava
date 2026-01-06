package org.example.Dao.Interface;

import java.util.List;

public interface InterfaceDao<T> {
    void save(T entity);
    T findById(Long id);
    List<T> findAll();
    void update(T entity);
    void delete(Long id);
}
