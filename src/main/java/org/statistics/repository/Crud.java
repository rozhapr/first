package org.statistics.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class Crud<T, I extends Number> {
    @PersistenceContext
    private EntityManager entityManager;

    public void save(T t) { entityManager.persist(t); }

    public void update(T t) {
        entityManager.merge(t);
    }

    public void delete(T t) {
        entityManager.remove(entityManager.merge(t));
    }

    public T selectOne(Class<T> tClass, I id) {
        return entityManager.find(tClass, id);
    }

    public List<T> selectAll(Class<T> tClass) {
        Entity entity = tClass.getAnnotation(Entity.class);
        String entityName = entity.name();
        String jpql = "select entity from " + entityName + " entity";
        Query query = entityManager.createQuery(jpql);
        List<T> tList = query.getResultList();
        return tList;
    }
}
