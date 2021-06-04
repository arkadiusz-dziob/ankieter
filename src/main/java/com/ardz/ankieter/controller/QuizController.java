package com.ardz.ankieter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {
	
	@PostMapping({"/quiz"})
    public String quiz(
    		@RequestParam(value="id", required=true) Long id,
    		Model model
    		){
		model.addAttribute("nr_pytania", 1);
		model.addAttribute("ilosc_pytan", 2);
		model.addAttribute("id", id);
        return "quiz";
    }
	
}
