package com.services.driver;


import com.exception.ResourceNotFoundException;
import com.models.Auto;
import com.models.Driver;
import com.repositories.AutoRepository;
import com.repositories.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DriverServiceImpl implements DriverService {

    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private AutoRepository autoRepository;

    @Override
    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public void saveDriver(Driver theDriver) {
        driverRepository.save(theDriver);
    }

    @Override
    public Driver getDriver(int id) throws ResourceNotFoundException {
        return driverRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(id));
    }

    @Override
    public void deleteDriver(int theId) {
        driverRepository.deleteById(theId);
    }
}

