package ru.sbt.vngilev.recipebookaws.common;

import java.util.List;

public interface GenericDao<T, PK> {
    T create(T t);

    T get(PK id);

    T update(T t);

    void delete(PK id);

    List<T> getAll();

    Class<T> getEntityClass();
}
