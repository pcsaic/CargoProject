package net.dao;
import net.JPA.AbstractDao;
import net.entity.Truck;

import java.util.List;

public interface TruckDao extends AbstractDao<Truck>{
    List<Truck> findAll();
    Truck findById(int id);
}
