package com.ardz.ankieter.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, HttpServletResponse response,
    						@RequestParam(value = "error", required = false) String error, 
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model) {
        String errorMessge = null;
        if(error != null) {
            errorMessge = "Username or Password is incorrect !!";
            model.addAttribute("error", errorMessge);
        }
        if(logout != null) {
        	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (auth != null){    
                new SecurityContextLogoutHandler().logout(request, response, auth);
            }
            errorMessge = "Zostałeś wylogowany";
            model.addAttribute("logout", errorMessge);
        }
        return "login";
    }
  
}
