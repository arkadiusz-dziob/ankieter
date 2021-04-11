package com.ardz.ankieter.data.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.ardz.ankieter.model.Ankieta;

public interface AnkietyRepository extends CrudRepository<Ankieta, Long> {

	Optional<Ankieta> findById(Long id);

	@Procedure("ADD_OR_UPDATE_POLL")
	void addOrUpdateAnkieta(@Param("POLL_ID") Long id, @Param("POLL_TEXT") String nazwa, @Param("POLL_PARENT_ID") Long ankieta_id);
}
