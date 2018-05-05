package net;

/**
 * В основе провайдера лежит паттерн Singleton
 * провайдер(подключение к БД) создается только
 * тогда, когда нет других подключений init(),
 * когда заканчивается работа он разрывает подключение destroy()
 **/

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EntityManagerProvider {
    private static EntityManagerProvider instance = new EntityManagerProvider();
    private final EntityManager entityManager;
    private EntityManagerProvider() {
        entityManager = Persistence.createEntityManagerFactory("cargo").createEntityManager();
    }
    public static EntityManager getEntityManager(){
        return instance.entityManager;
    }
    public static void init() {
        if (instance == null) {
            synchronized (EntityManagerProvider.class) {
                if (instance == null) {
                    instance = new EntityManagerProvider();
                }
            }
        }
    }
    public static void destroy(){
        instance.entityManager.close();
        instance.entityManager.getEntityManagerFactory().close();
    }
}

