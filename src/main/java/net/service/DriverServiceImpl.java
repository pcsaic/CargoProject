package net.service;

import net.dao.DriverDao;
import net.dao.DriverDaoImpl;
import net.entity.Driver;

public class DriverServiceImpl implements DriverService{

    DriverDao driverDao = new DriverDaoImpl() ;

    @Override
    public void createDriver(Driver driver) {
        driverDao.insert(driver);

    }


}
