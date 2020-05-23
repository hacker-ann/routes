package com.ania.springdemo.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ania.springdemo.entity.Routes;

@Repository
public class StatisticsDAOImplementation implements StatisticsDAO {
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public Long countAll() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  
		Query theQuery = 
				currentSession.createQuery("select count(*) from Routes");
		
		// execute query and get result 
	
		Long count = (Long)theQuery.uniqueResult();
		System.out.println("count: " + count.toString());
				 
		return count;
	}


	@Override
	public Long countLast7Days() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// create a query  
		Query theQuery = 
				currentSession.createQuery("select count(*) from Routes where date >= current_date()-7");
		
		// execute query and get result 
	
		Long count = (Long)theQuery.uniqueResult();
		System.out.println("count: " + count);
			 
		return count;
	}


	@Override
	public Date startDate() {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				
				// create a query  
				Query theQuery = 
						currentSession.createQuery("select min(date) from Routes");
				
				// execute query and get result 
			
				Date startDate = (Date)theQuery.uniqueResult();
				System.out.println("Start date: " + startDate);
					 
				return startDate;
	}


	@Override
	public Date endDate() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  
		Query theQuery = 
				currentSession.createQuery("select max(date) from Routes");
		
		// execute query and get result 
	
		Date endDate = (Date)theQuery.uniqueResult();
		System.out.println("End date: " + endDate);
			 
		return endDate;
	}


	@Override
	public List<Routes> findPopularCrag() {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
						
				// create a query   MAX(COUNT(pole)) FROM tabela GROUP BY pole
				Query theQuery = 
					currentSession.createQuery("select new List (cragOrSector, count(*)) from Routes group by cragOrSector order by count(*) desc");
				
				// execute query and get result 
			
				List<Routes> popularCrag = theQuery.setMaxResults(5).getResultList();
				System.out.println("Popular Crag: ");
				for (int i=0; i<popularCrag.size(); i++) {
					System.out.println(popularCrag.get(i));
				}	
				return popularCrag;
	}


	}

