package net.JPA;

import net.EntityManagerProvider;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public abstract class JpaAbstractDao<T> implements  AbstractDao<T>{
    public void insert(T t) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();

    }
    public void delete(T t) {
        EntityManager entityManager = EntityManagerProvider.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(t);
        entityManager.getTransaction().commit();

    }

}
