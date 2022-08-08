package com.joseph.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("/")
	public String test(HttpSession session) {
		

		if (session.getAttribute("count") == null) {
			// Use setAttribute to initialize the count in session
			session.setAttribute("count", 0);
			}
			else {
				session.setAttribute("count",(Integer)session.getAttribute("count")+1);
			// increment the count by 1 using getAttribute and setAttribute
			}
			return "index.jsp";
		
		
	}

	// ...
	@RequestMapping("/count")
	public String showCount(HttpSession session, Model model) {
		Integer currentCount = (Integer) session.getAttribute("count");
		model.addAttribute("countToShow", currentCount);
		return "showCount.jsp";
	}
	// ...

}
