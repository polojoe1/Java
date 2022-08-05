package com.joseph.hellospring.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class MainController {
	@RequestMapping("")
	public String hello() {
		return "Welcome";
	}

	@RequestMapping("/today")
	public String luck() {
		return "today is your lucky day";
}
	@RequestMapping("/tomorrow")
	public String tomorrow() {
		return "Tomorrow is the day where change begins";
	}
}
