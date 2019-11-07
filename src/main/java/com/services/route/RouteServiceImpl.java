package com.services.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.ResourceNotFoundException;
import com.models.Route;
import com.repositories.RouteRepository;

@Service
public class RouteServiceImpl implements RouteService {

	@Autowired
	private RouteRepository routeRepository;
	
	@Override
	public void saveRoute(Route route) throws ResourceNotFoundException {

		routeRepository.save(route);
	}

	@Override
	public void deleteRoute(int routeId) throws ResourceNotFoundException { 
		routeRepository.deleteById(routeId);
	}

	@Override
	public Route getRoute(int routeId) throws ResourceNotFoundException {
		return routeRepository.findById(routeId).orElseThrow(
                () -> new ResourceNotFoundException(routeId));
	}

}
