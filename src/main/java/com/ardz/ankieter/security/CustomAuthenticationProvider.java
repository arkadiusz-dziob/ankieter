package com.ardz.ankieter.security;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ardz.ankieter.data.repositories.LogowaniaRepository;
import com.ardz.ankieter.data.repositories.OsobyRepository;
import com.ardz.ankieter.model.Logowanie;
import com.ardz.ankieter.model.Osoba;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	OsobyRepository osoby;
	
	@Autowired
	LogowaniaRepository lr;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
    @Override
    public Authentication authenticate(Authentication authentication) 
      throws AuthenticationException {
 
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        
		Optional<Osoba> osoba = osoby.findByNazwa(name);
		if (osoba.isPresent()) {
			if (passwordEncoder.matches(password, osoba.get().getHaslo())) {
				List<GrantedAuthority> auths = new LinkedList<>();
				auths.add(new SimpleGrantedAuthority(osoba.get().getRola()));
				
				lr.save(new Logowanie(null, osoba.get().getNazwa(), osoba.get().getRola(), LocalDateTime.now()));
				return new UsernamePasswordAuthenticationToken(
						name, osoba.get().getHaslo(), auths);
			}
		}
		
        return null;
    }

	@Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}