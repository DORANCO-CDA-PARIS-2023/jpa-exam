package com.doranco.interfaces;

public interface Icrud<T> {
    public void create(T t);

    public void update(T t);

    public void delete(T t);

    public T findById(int id);

    public T[] findAll();
}
