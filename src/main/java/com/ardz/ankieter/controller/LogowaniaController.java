package com.ardz.ankieter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ardz.ankieter.data.repositories.LogowaniaRepository;

@Controller
public class LogowaniaController {

	@Autowired
	LogowaniaRepository lr;
	
    @GetMapping({"/logowania"})
    public String get(Model model) {
        model.addAttribute("logowania", lr.findAll());
        return "logowania";
    }
  
}
