package com.ardz.ankieter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ardz.ankieter.data.AnkietaDTO;
import com.ardz.ankieter.services.AnkietyService;

@Controller
public class AnkietyController {
	
	@Autowired
	AnkietyService ankietyService;
	
    @GetMapping({"/", "/ankiety"})
    public String get(Model model) {
    	model.addAttribute(new AnkietaDTO());
        model.addAttribute("ankiety", ankietyService.ankiety());
        return "ankiety";
    }
    
    @PostMapping({"/ankiety"})
    public void post(Model model, 
    		@Valid @ModelAttribute("ankietaForm") AnkietaDTO ankietaForm, 
    		BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
    		model.addAttribute("error", "error");
		}
    	try {
    		ankietyService.saveOrUpdate(ankietaForm);
    	} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
    	model.addAttribute("ankiety", ankietyService.ankiety());
    }
    
    @PostMapping({"/ankiety/usun"})
    public RedirectView usun(Model model, 
    		@RequestParam(value="id", required=true) Long id
    		) {
    	try {
    		ankietyService.deleteById(id);
    	} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
    	model.addAttribute("ankiety", ankietyService.ankiety());
    	return new RedirectView("/ankiety");
    }

    @PostMapping({"/ankiety/zmien"})
    public RedirectView zmien(Model model, 
    		@RequestParam(value="id", required=true) Long id,
    		@RequestParam(value="nazwa", required=true) String nazwa
    		) {
    	try {
    		ankietyService.zmienNazwe(id, nazwa);
    	} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
    	return new RedirectView("/ankiety");
    }
    
    @PostMapping({"/ankiety/dodaj"})
    public ModelAndView dodaj(Model model, 
    		@RequestParam(value="nazwa", required=true) String nazwa
    		) {
    	try {
    		ankietyService.dodajAnkiete(nazwa);
    	} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
    	return new ModelAndView("redirect:/ankiety");
    }
}
