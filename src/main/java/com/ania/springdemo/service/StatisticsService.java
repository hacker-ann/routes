package com.ania.springdemo.service;

import java.util.Date;
import java.util.List;

import com.ania.springdemo.entity.Routes;

public interface StatisticsService {

	public Long countAll();
	public Long countLast7Days();
	public Date startDate();
	public Date endDate();
	public List<Routes> findPopularCrag();

}
