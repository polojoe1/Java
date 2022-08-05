package com.joseph.helloHuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloHuman {
	@RequestMapping("/")
	public String hello() {
		return "Hello Human!";
	}
	@RequestMapping("/hello")
	public String helloWithName(@RequestParam(value="name", required=false)String searchQuery, @RequestParam(value="lastName", required=false)String lastName) {
		return "Hello " + searchQuery + " " + lastName;
	}
}
