package com.ardz.ankieter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ardz.ankieter.data.OsobaDTO;
import com.ardz.ankieter.services.OsobyService;

@Controller
public class RegistrationController {
	
	@Autowired
	OsobyService osobyService;

    @RequestMapping(value={"/registration"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("registration");
        return modelAndView;
    }
    
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String loginPage(@RequestParam(value = "username", required = true) String username, 
                            @RequestParam(value = "password", required = true) String password,
                            @RequestParam(value = "password", required = true) String role,
                            Model model) {
        try {
        	osobyService.save(new OsobaDTO(username, password, role));
        } 
        catch (Exception e) {
        	model.addAttribute("error", e.getMessage());
        }
        return "registration";
    }
	
}
