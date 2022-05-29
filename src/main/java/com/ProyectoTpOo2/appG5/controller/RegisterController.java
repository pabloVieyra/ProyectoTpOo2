package com.ProyectoTpOo2.appG5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ProyectoTpOo2.appG5.helpers.ViewRouteHelper;
import com.ProyectoTpOo2.appG5.service.CursadaService;
import com.ProyectoTpOo2.appG5.service.FinalService;



@Controller
public class RegisterController {
	
	@Autowired
	FinalService finalService;
	
	@Autowired
	CursadaService cursadaService;
	
	@GetMapping({"/","/login"})
	public String index() {
		return ViewRouteHelper.INDEX;
	}
	
	
	@GetMapping("/menu")
	public String menu() {
		return ViewRouteHelper.MENU;
	}
	
	@GetMapping("/admin/1")
	public String admin(Model model) {
		model.addAttribute("finalesList", finalService.getAllFinales());
		model.addAttribute("cursadaList", cursadaService.getAllCursadas());
		
		return ViewRouteHelper.ADMIN;
	}
	
	@GetMapping("/manager/2")
	public String manager(Model model) {
		model.addAttribute("finalesList", finalService.getAllFinales());
		model.addAttribute("cursadaList", cursadaService.getAllCursadas());
		
		return ViewRouteHelper.MANAGER;
	}
	
	@GetMapping("/professor/3")
	public String professor() {
		return ViewRouteHelper.PROFESSOR;
	}
}

