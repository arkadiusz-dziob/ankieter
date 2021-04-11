package com.ardz.ankieter.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.ardz.ankieter.services.OsobyService;

@Controller
public class LogowanieController {
	
	private static final String USERNAME = "username";

	@Autowired
	OsobyService os;
	
	@Autowired
	ObjectFactory<HttpSession> httpSessionFactory;
	
    @GetMapping({"/logowanie"})
    public String get(Model model, String error) {
    	 if (error != null){
    		 model.addAttribute("loginError", error);
    	 }
	     return "logowanie";
    }
    
    @PostMapping({"/logowanie"})
    public String post(Model model, 
    		@RequestParam(value=USERNAME, required=true) String username
    		) {
    	if (os.exists(username)) {
    		httpSessionFactory.getObject().setAttribute(USERNAME, username);
        	return "redirect:/ankiety";
    	}
    	model.addAttribute("loginError", "Nieprawidłowy login: "+ username);
    	return "logowanie";
    }
}
