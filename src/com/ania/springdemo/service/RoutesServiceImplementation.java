package com.ania.springdemo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ania.springdemo.dao.RoutesDAO;
import com.ania.springdemo.entity.Routes;


@Service
public class RoutesServiceImplementation implements RoutesService {

	// need to inject routes dao
	@Autowired
	private RoutesDAO routesDAO;
	
	@Override
	@Transactional
	public List<Routes> getRoutes() {
			return routesDAO.getRoutes();
	}

	@Override
	@Transactional
	public void saveRoutes(Routes theRoutes) {
		routesDAO.saveRoutes(theRoutes);

	}

	@Override
	@Transactional
	public Routes getRoutes(int theId) {
		return routesDAO.getRoutes(theId);
	}

	@Override
	@Transactional
	public void deleteRoutes(int theId) {
	routesDAO.deleteRoutes(theId);

	}

	@Override
	@Transactional
	public List<Routes> searchRoutes(String theSearchName) {
				return routesDAO.searchRoutes(theSearchName);
	}

}
