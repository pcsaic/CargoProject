package net.service;

import net.entity.Driver;

import java.util.List;

public interface DriverService {

    void createDriver (Driver driver);
    List<Driver> findAll();

}
