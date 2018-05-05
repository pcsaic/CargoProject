package net.service;

import net.entity.Truck;

import java.util.List;

public interface TruckService {
    List <Truck> findAll();
    void createTruck(Truck truck);
//    void findByNumber();
//    void setDriver();
    void delete(int id);
}
