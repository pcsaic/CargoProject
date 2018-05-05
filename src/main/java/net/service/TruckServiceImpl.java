package net.service;

import net.dao.TruckDao;
import net.dao.TruckDaoImpl;
import net.entity.Truck;
import java.util.List;

public class TruckServiceImpl implements TruckService{
        TruckDao truckDao = new TruckDaoImpl();

    @Override
    public List<Truck> findAll() {
        List <Truck> trucks;
        trucks = truckDao.findAll();
        return trucks;
    }
    @Override
    public void createTruck(Truck truck){
        truckDao.insert(truck);
    }

    @Override
    public void delete(int id) {
        Truck truck;
        truck = truckDao.findById(id);
        if (truck != null){
            truckDao.delete(truck);
        }
    }
}
