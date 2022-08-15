package com.joseph.loginReg.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.joseph.loginReg.models.User;
import com.joseph.loginReg.services.UserService;

@Controller
public class HomePage {
	@Autowired
	private UserService userServ;
	@GetMapping("/home")
    public String home(HttpSession session, Model model) {
		Long userId = (Long)session.getAttribute("user_id");
		if(userId == null) {
			return "redirect:/";
		}
		else {
			User thisUser = userServ.findOne(userId);
			model.addAttribute("thisUser", thisUser);
		}
		return "home.jsp";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
