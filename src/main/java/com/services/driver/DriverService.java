package com.services.driver;

import com.exception.ResourceNotFoundException;
import com.models.Auto;
import com.models.Driver;

import java.util.List;
import java.util.Set;

public interface DriverService {


        List<Driver> getDrivers();

        void saveDriver(Driver theDriver);

        Driver getDriver  (int theId)throws ResourceNotFoundException;

        void deleteDriver (int theId )throws ResourceNotFoundException ;
}
