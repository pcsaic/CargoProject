package net.dao;

import net.EntityManagerProvider;
import net.JPA.JpaAbstractDao;
import net.entity.Driver;

import javax.persistence.EntityManager;
import java.util.List;

public class DriverDaoImpl extends JpaAbstractDao<Driver> implements DriverDao{

    public List<Driver> findAll() {
       List <Driver> driverList = EntityManagerProvider.getEntityManager().createQuery("SELECT a FROM Driver a", Driver.class).getResultList();
       return driverList;
    }
}
