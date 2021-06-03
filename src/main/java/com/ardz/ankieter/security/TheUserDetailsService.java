package com.ardz.ankieter.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ardz.ankieter.data.repositories.OsobyRepository;
import com.ardz.ankieter.model.Osoba;

@Service("userDetailsService")
public class TheUserDetailsService implements UserDetailsService {
	
	@Autowired
	OsobyRepository osoby;
	
	@Autowired 
	PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		Optional<Osoba> osoba = osoby.findByNazwa(name);
		if (osoba.isPresent()) {
			//System.out.println("Login: %s Hasło: %s Bcrypt: %s ".formatted(osoba.get().getNazwa(), osoba.get().getHaslo(), passwordEncoder.encode(osoba.get().getHaslo())));
			return new UserPrincipal(osoba.get());
		}
		throw new UsernameNotFoundException(name);
	}
}
