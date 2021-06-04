package com.ardz.ankieter.data.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.ardz.ankieter.model.Tlumaczenie;

public interface TlumaczeniaRepository extends CrudRepository<Tlumaczenie, Long> {
	
	Optional<Tlumaczenie> findByAnkietaId(Long id);
	
}
