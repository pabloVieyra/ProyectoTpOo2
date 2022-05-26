package com.ProyectoTpOo2.appG5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ProyectoTpOo2.appG5.helpers.ViewRouteHelper;


@Controller
public class RegisterController {
	
	@GetMapping({"/","/login"})
	public String index() {
		return ViewRouteHelper.INDEX;
	}
	
	
	@GetMapping("/menu")
	public String menu() {
		return ViewRouteHelper.MENU;
	}
	
	@GetMapping("/admin/1")
	public String admin() {
		return ViewRouteHelper.ADMIN;
	}
	
	@GetMapping("/manager/2")
	public String manager() {
		return ViewRouteHelper.MANAGER;
	}
	
	@GetMapping("/professor/3")
	public String professor() {
		return ViewRouteHelper.PROFESSOR;
	}
}

