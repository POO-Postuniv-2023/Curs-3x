package com.ubb.postuniv.repository;

import com.ubb.postuniv.domain.Entity;

import java.util.List;

public interface IRepository<T extends Entity> {
    void create(T entity) throws Exception;
    void update(T entity) throws Exception;
    List<T> readAll();
    T read(int id);
    void delete(int id) throws Exception;
}
