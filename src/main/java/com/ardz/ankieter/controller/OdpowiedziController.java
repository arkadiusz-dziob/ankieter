package com.ardz.ankieter.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ardz.ankieter.data.AnkietaDTO;
import com.ardz.ankieter.services.AnkietyService;

@Controller
public class OdpowiedziController {
	
	@Autowired
	AnkietyService ankietyService;
	
    @GetMapping({"/odpowiedzi"})
    public String get(@RequestParam(value="id", required=true) Long id, Model model) {
    	Optional<AnkietaDTO> ankieta = ankietyService.znajdzPoId(id);
    	if (ankieta.isEmpty()) {
    		return "error";
    	}
    	List<AnkietaDTO> ankiety = ankietyService.znajdzPoParentId(id);
    	model.addAttribute("ankiety", ankiety);
    	model.addAttribute("nazwa", ankieta.get().getNazwa());
    	model.addAttribute("id", id);
    	return "odpowiedzi";
    }
    
    @PostMapping({"/odpowiedzi/usun"})
    public ModelAndView usun(Model model, 
    		@RequestParam(value="ankieta_id", required=true) Long ankieta_id,
    		@RequestParam(value="id", required=true) Long id
    		) {
    	try {
    		ankietyService.deleteById(id);
    	} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
    	model.addAttribute("ankiety", ankietyService.ankiety());
    	return new ModelAndView("redirect:/odpowiedzi?id="+ankieta_id);
    }
    
    @PostMapping({"/odpowiedzi/dodaj"})
    public ModelAndView dodaj(Model model, 
    		@RequestParam(value="id", required=true) Long id,
    		@RequestParam(value="nazwa", required=true) String nazwa
    		) {
    	try {
    		ankietyService.dodajPytanie(id, nazwa);
    	} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
    	return new ModelAndView("redirect:/odpowiedzi?id="+id);
    }
    
    @PostMapping({"/odpowiedzi/zmien"})
    public ModelAndView zmien(Model model, 
    		@RequestParam(value="id", required=true) Long id,
    		@RequestParam(value="ankieta_id", required=true) Long ankieta_id,
    		@RequestParam(value="nazwa", required=true) String nazwa
    		) {
    	try {
    		ankietyService.zmienNazwe(id, nazwa);
    	} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
    	return new ModelAndView("redirect:/odpowiedzi?id="+ankieta_id);
    }
}
