package com.ardz.ankieter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardz.ankieter.data.repositories.OsobyRepository;

@Service
public class OsobyService {

	@Autowired
	OsobyRepository or;
	
	public boolean exists(String username) {
		return (or.findByNazwa(username)).isPresent();
	}
}
