package com.ania.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/routes")
	public String mainPage() {

		return "main-menu";
	}
	
}
