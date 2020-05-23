package com.ania.springdemo.dao;

import java.util.List;

import com.ania.springdemo.entity.Routes;


public interface RoutesDAO {

	public List<Routes> getRoutes();

	public void saveRoutes(Routes theRoutes);

	public Routes getRoutes(int theId);

	public void deleteRoutes(int theId);

	public List<Routes> searchRoutes(String theSearchName);
	
	
}
