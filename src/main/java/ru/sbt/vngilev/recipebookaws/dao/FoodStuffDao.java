package ru.sbt.vngilev.recipebookaws.dao;

import org.springframework.stereotype.Repository;
import ru.sbt.vngilev.recipebookaws.entity.Foodstuff;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FoodStuffDao {

    @PersistenceContext
    private EntityManager entityManager;

    public void create(Foodstuff foodstuff) {
        entityManager.persist(foodstuff);
    }

    public Foodstuff get(Long id) {
        return entityManager.find(Foodstuff.class, id);
    }

    public List getAll() {
        return entityManager.createQuery("select f from " + this.getClass().getSimpleName() + " f").getResultList();
    }

    public void update(Foodstuff foodstuff) {
        entityManager.merge(foodstuff);
    }

    private void delete(Long id) {
        Foodstuff foodstuff = entityManager.find(Foodstuff.class, id);
        if (foodstuff != null) {
            entityManager.remove(foodstuff);
        }
    }
}