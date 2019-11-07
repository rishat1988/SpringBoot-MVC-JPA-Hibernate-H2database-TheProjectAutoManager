package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.models.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer>{

}
