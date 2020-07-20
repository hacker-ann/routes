package com.ania.springdemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ania.springdemo.entity.Routes;
import com.ania.springdemo.service.RoutesService;


@Controller
@RequestMapping("/routes")
public class RoutesController {
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(java.sql.Date.class, new CustomDateEditor(dateFormat, false));
	}
	

	// need to inject our routes service
	@Autowired
	private RoutesService routesService;
		
	@GetMapping("/list")
	public String listRoutes(Model theModel) {
		
		// get routes from the service
		List<Routes> theRoutes = routesService.getRoutes();
				
		// add routes to the model
		theModel.addAttribute("routes", theRoutes);
		
		return "list-routes";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Routes theRoutes = new Routes();
		
		theModel.addAttribute("routes", theRoutes);
		
		return "routes-form";
	}
	
	@PostMapping("/saveRoutes")
	public String saveRoutes(@Valid @ModelAttribute("routes") Routes theRoutes,
		BindingResult theBindingResult) {
			if (theBindingResult.hasErrors()) {
				return "routes-form";
			}
			else {
				// save route using  service
				System.out.println("Received update for Routes wiht date: " + theRoutes.getDate().toGMTString());
				routesService.saveRoutes(theRoutes);	
				return "redirect:/routes/list";
			}
		}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("routeId") int theId,
									Model theModel) {
		
		// get the route from our service
		Routes theRoute = routesService.getRoutes(theId);	
		
		// set route as a model attribute to pre-populate the form
		theModel.addAttribute("routes", theRoute);
		
		// send over to our form		
		return "routes-form";
	}
	
	@GetMapping("/delete")
	public String deleteRoute(@RequestParam("routeId") int theId) {
		
		// delete the route
		routesService.deleteRoutes(theId);
		
		return "redirect:/routes/list";
	}
	
	@GetMapping("/search")
	public String searchRoutes(@RequestParam("theSearchName") String theSearchName,
									Model theModel) {

		// search routes from the service
		List<Routes> theRoute = routesService.searchRoutes(theSearchName);
				
		// add the route to the model
		theModel.addAttribute("routes", theRoute);

		return "list-routes";
	}	
	}
