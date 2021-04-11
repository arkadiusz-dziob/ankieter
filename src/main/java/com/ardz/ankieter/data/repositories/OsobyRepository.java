package com.ardz.ankieter.data.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ardz.ankieter.model.Osoba;


public interface OsobyRepository extends CrudRepository<Osoba, Long> {

	Optional<Osoba> findById(Long id);

	Optional<Osoba> findByNazwa(String username);
	
}
