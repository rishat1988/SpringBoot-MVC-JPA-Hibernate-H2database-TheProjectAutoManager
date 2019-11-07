package com.repositories;


import com.models.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.BitSet;
import java.util.Collection;
import java.util.Set;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
//    void deleteAllInBatch(Set<Driver> drivers);
//    Set<Driver> findByFullName (String driverFullName);


}