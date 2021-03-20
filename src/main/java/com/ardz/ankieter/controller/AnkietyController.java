package com.ardz.ankieter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.ardz.ankieter.data.AnkietaDTO;
import com.ardz.ankieter.services.AnkietyService;

@Controller
public class AnkietyController {
	
	@Autowired
	AnkietyService ankietyService;
	
    @GetMapping({"/ankiety"})
    public void get(Model model) {
        model.addAttribute("ankieta", new AnkietaDTO());
        model.addAttribute("ankiety", ankietyService.wszystkie());
    }
    
    @PostMapping({"/ankiety"})
    public RedirectView post(Model model, 
    		@RequestParam(value="id", required=false) Long id,
    		@RequestParam(value="nazwa", required=false) String nazwa,
    		@RequestParam(value="id_ankiety", required=false) Long id_ankiety
    		) {
    	AnkietaDTO ankieta = new AnkietaDTO(id, nazwa, id_ankiety);
    	model.addAttribute("ankiety", ankietyService.wszystkie());
		model.addAttribute("ankieta", new AnkietaDTO());
    	ankietyService.saveOrUpdate(ankieta);
    	
    	return new RedirectView("/ankiety");
    }
}
