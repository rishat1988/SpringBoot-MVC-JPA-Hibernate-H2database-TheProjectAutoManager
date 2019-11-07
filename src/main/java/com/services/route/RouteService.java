package com.services.route;

import com.exception.ResourceNotFoundException;
import com.models.Route;

public interface RouteService {
	void saveRoute(Route route) throws ResourceNotFoundException;

	void deleteRoute(int routeId) throws ResourceNotFoundException;

	Route getRoute(int routeId) throws ResourceNotFoundException;
}
