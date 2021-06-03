package com.ardz.ankieter.services;

import java.time.LocalDate;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ardz.ankieter.data.OsobaDTO;
import com.ardz.ankieter.data.repositories.OsobyRepository;
import com.ardz.ankieter.model.Osoba;

@Service
public class OsobyService {
	
    @Autowired
    PasswordEncoder passwordEncoder;

	@Autowired
	OsobyRepository or;
	
	public boolean exists(String username) {
		return (or.findByNazwa(username)).isPresent();
	}
	
	@Transactional
    public Osoba save(final OsobaDTO osobaDTO) {
		if (osobaDTO.getNazwa() == null || osobaDTO.getNazwa().trim().length()<3) {
			throw new IllegalArgumentException("Nieprawidłowa nazwa użytkownika.");
		}
		if (exists(osobaDTO.getNazwa())) {
			throw new IllegalArgumentException("Użytkownik "+osobaDTO.getNazwa() + " już istnieje.");
		}
    	Osoba osoba = new Osoba(null, 
    			LocalDate.now(), 
    			osobaDTO.getNazwa(), 
    			passwordEncoder.encode(osobaDTO.getHaslo()),
    			osobaDTO.getRola());
        return or.save(osoba);
    }
}
