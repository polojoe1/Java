package com.joseph.omikuji.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiControllers {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping(value="/info", method=RequestMethod.POST)
	public String firstRoute(
			@RequestParam(value="number") Integer number,
			@RequestParam(value="city") String city,
			@RequestParam(value="name") String name,
			@RequestParam(value="hobby") String hobby,
			@RequestParam(value="animal") String animal,
			@RequestParam(value="nice") String nice,
			HttpSession session
			) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("animal", animal);
		session.setAttribute("nice", nice);
		return "redirect:/omikuji";
	}
	
	@RequestMapping("/omikuji")
	public String omiku(Model model,HttpSession session) {
		model.addAttribute("number",session.getAttribute("number"));
		model.addAttribute("city",session.getAttribute("city"));
		model.addAttribute("name",session.getAttribute("name"));
		model.addAttribute("hobby",session.getAttribute("hobby"));
		model.addAttribute("animal",session.getAttribute("animal"));
		model.addAttribute("nice",session.getAttribute("nice"));

		return "omikuji.jsp";
	}
}
