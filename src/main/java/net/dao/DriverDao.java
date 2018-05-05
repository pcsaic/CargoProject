package net.dao;

import net.JPA.AbstractDao;
import net.entity.Driver;

import java.util.List;

public interface DriverDao extends AbstractDao<Driver> {
    List <Driver> findAll();

}
