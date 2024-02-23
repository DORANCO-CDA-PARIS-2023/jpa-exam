package com.doranco.services;

import java.sql.SQLException;
import java.util.List;

public interface IServiceCrud {
    public <T> T find(int id, Class<T> entityClass) throws SQLException;
    public <T> List<T> findAll(Class<T> entityClass) throws SQLException;
    public <T> void create(T entity) throws SQLException;
    public void delete(int id, Class<?> entityClass) throws SQLException;
    public <T> T update(int id, T entity) throws SQLException;
}

