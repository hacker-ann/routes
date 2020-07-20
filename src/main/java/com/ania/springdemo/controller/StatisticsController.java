package com.ania.springdemo.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import com.ania.springdemo.entity.Routes;
import com.ania.springdemo.service.StatisticsService;


@Controller
@RequestMapping("/routes")
public class StatisticsController {
	

	// need to inject statistics service
	@Autowired
	private StatisticsService statisticsService;
		
	@GetMapping ("/statistics")
	public String displayStatistics (Model theModel) {
		
		// get statistics from  service
		Long theStatistic = statisticsService.countAll();	
		Long last7Days = statisticsService.countLast7Days();
		Date startDate = statisticsService.startDate();
		Date endDate = statisticsService.endDate();
		List<Routes> popularCrag = statisticsService.findPopularCrag();
		
		
		// add statistics to the model
		theModel.addAttribute("numberOfRoutes", theStatistic);
		theModel.addAttribute("last7Days", last7Days);
		theModel.addAttribute("startDate", startDate);
		theModel.addAttribute("endDate", endDate);
		theModel.addAttribute("popularCrag", popularCrag);
	
		
		// send over to our form		
		return "statistics-list";
	}
	
	

	
	
}
