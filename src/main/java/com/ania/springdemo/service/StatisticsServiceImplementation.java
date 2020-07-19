package com.ania.springdemo.service;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ania.springdemo.dao.StatisticsDAO;
import com.ania.springdemo.entity.Routes;


@Service
public class StatisticsServiceImplementation implements StatisticsService {

	// need to inject statistics dao
	@Autowired
	private StatisticsDAO statisticsDAO;
	
	@Override
	@Transactional
	public Long countAll() {
				return statisticsDAO.countAll();
	}

	@Override
	@Transactional
	public Long countLast7Days() {
			return statisticsDAO.countLast7Days();
	}

	@Override
	@Transactional
	public Date startDate() {
		return statisticsDAO.startDate();
	}

	@Override
	@Transactional
	public Date endDate() {
			return statisticsDAO.endDate();	
	}

	@Override
	@Transactional
	public List<Routes> findPopularCrag() {
		return statisticsDAO.findPopularCrag();
	}



	
}
