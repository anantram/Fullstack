package com.restapi.com.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.restapi.com.repositories.UserRepository;

@Controller
public class MVCController {
	UserRepository userRepo;
	
	public MVCController(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}
	
	
	@GetMapping(value="/userMVC")
    public String greeting(Model model) {
        model.addAttribute("name", userRepo.findBy());
        return "Users.html";
    }

}
