package com.ania.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ania.springdemo.entity.Routes;


@Repository
public class RoutesDAOImplementation implements RoutesDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Routes> getRoutes() {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
						
				// create a query  ... sort by date asc
				Query<Routes> theQuery = 
						currentSession.createQuery("from Routes order by date desc",
													Routes.class);
				
				// execute query and get result list
				List<Routes> routes = theQuery.getResultList();
				
				// return the results
		return routes;
	}

	@Override
	public void saveRoutes(Routes theRoutes) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the routes
		currentSession.saveOrUpdate(theRoutes);

	}

	@Override
	public Routes getRoutes(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Routes theRoute = currentSession.get(Routes.class, theId);
		
		return theRoute;
		
	}

	@Override
	public void deleteRoutes(int theId) {
	
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Routes where id=:routeId");
		theQuery.setParameter("routeId", theId);
		
		theQuery.executeUpdate();

	}

	@Override
	public List<Routes> searchRoutes(String theSearchName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		//
		// only search by name if theSearchName is not empty
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			// search for firstName or lastName ... case insensitive
			theQuery =currentSession.createQuery("from Routes where lower(routeName) like :theName or lower(country) like :theName or lower(climbingArea) like :theName or lower(climbingArea) like :theName or lower(crag_or_sector) like :theName or lower(grade) like :theName or lower(style) like :theName", Routes.class);
			theQuery.setParameter("theName", "%" + theSearchName.toLowerCase() + "%");

		}
		else {
			// theSearchName is empty ... so just get all routes
			theQuery =currentSession.createQuery("from Routes", Routes.class);			
		}
		
		// execute query and get result list
		List<Routes> routes = theQuery.getResultList();
				
		// return the results		
		return routes;
	}

	
}
