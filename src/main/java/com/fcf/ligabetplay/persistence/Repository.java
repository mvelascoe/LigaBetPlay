package com.fcf.ligabetplay.persistence;

import java.util.List;

public interface Repository<T> {
    T findById(int id);
    List<T> findAll();
    void save(T entity);
    void update(T entity);
    void delete(int id); 
}