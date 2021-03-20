package com.ardz.ankieter.data.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.ardz.ankieter.model.Ankieta;

public interface AnkietyRepository extends CrudRepository<Ankieta, Long> {

	Optional<Ankieta> findById(Long id);
	
}
