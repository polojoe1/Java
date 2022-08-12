package com.joseph.dojosAndNinjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.joseph.dojosAndNinjas.models.Dojo;
import com.joseph.dojosAndNinjas.models.Ninja;
import com.joseph.dojosAndNinjas.services.DojoService;
import com.joseph.dojosAndNinjas.services.NinjaService;


@Controller
public class MainController {
	
	//DEPENDECY INJECTION
	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	
	
	//ROUTES TO MAIN PAGE
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos/new";
	}
	
	
	//MAIN PAGE
	@GetMapping("/dojos/new")
	public String mainPage(@ModelAttribute("dojo") Dojo dojo, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos",allDojos);
		
		return "index.jsp";
	}
	
	//ADD DOJO ROUTE
	@PostMapping("/dojo")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos",allDojos);
		if (result.hasErrors()) {
			return "index.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/";
		}
	}
	
	//ADD NINJA
	@GetMapping("/ninja/new")
	public String newNinjaPage(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Ninja> allNinjas = ninjaService.allNinjas();
		model.addAttribute("allNinjas",allNinjas);
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos",allDojos);
		return "ninjas.jsp";
	}
	@PostMapping("/ninja")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos",allDojos);
		List<Ninja> allNinjas = ninjaService.allNinjas();
		model.addAttribute("allNinjas",allNinjas);
		if (result.hasErrors()) {
			return "ninjas.jsp";
		} else {
			ninjaService.createNinja(ninja);
			return "redirect:/ninja/new";
		}
	}
	
	@GetMapping("/dojo/{id}/info")
	public String oneEx(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
        model.addAttribute("dojo", dojo);
        return "oneDojo.jsp";
	}
	
}
