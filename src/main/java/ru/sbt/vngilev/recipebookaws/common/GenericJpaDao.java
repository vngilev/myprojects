package ru.sbt.vngilev.recipebookaws.common;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericJpaDao<T, PK> implements GenericDao<T, PK> {

    @PersistenceContext
    private EntityManager entityManager;
    protected Class<T> entityClass;

    public GenericJpaDao() {
        // чтобы aspectj корректно отрабатывал, делаем цикл
        Type genericSuperclass;
        Class<?> parametrizedClass = getClass();
        do {
            genericSuperclass = parametrizedClass.getGenericSuperclass();
            if (genericSuperclass instanceof Class) {
                parametrizedClass = (Class<?>) genericSuperclass;
            }
        } while (genericSuperclass != null && !(genericSuperclass instanceof ParameterizedType));
        this.entityClass = (Class<T>) ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }

    @Override
    public T get(PK id) {
        return entityManager.find(entityClass, id);
    }

    @Override
    public T create(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T update(T t) {
        return entityManager.merge(t);
    }

    @Override
    public void delete(PK id) {
        T customer = entityManager.find(entityClass, id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }

    @Override
    public Class<T> getEntityClass() {
        return entityClass;
    }

    @Override
    public List<T> getAll() {
        return entityManager.createQuery("select r from " + entityClass.getSimpleName() + " r").getResultList();
    }
}
