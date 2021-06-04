package com.ardz.ankieter.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardz.ankieter.data.AnkietaDTO;
import com.ardz.ankieter.data.repositories.AnkietyRepository;
import com.ardz.ankieter.data.repositories.TlumaczeniaRepository;
import com.ardz.ankieter.model.Ankieta;

@Service
public class AnkietyService {
	
	@Autowired
	private AnkietyRepository ar;
	
	@Autowired
	private TlumaczeniaRepository tr;
	
	@Transactional
	public void saveOrUpdate(AnkietaDTO ankietaDTO) {
		ar.addOrUpdateAnkieta(ankietaDTO.getId(), ankietaDTO.getNazwa(), ankietaDTO.getId_ankiety());
	}

	
	public List<AnkietaDTO> ankiety() {
		Iterable<Ankieta> wszystkie = ar.findByRodzicIdNull();
		List<AnkietaDTO> res = new ArrayList<>();
		wszystkie.forEach((a) -> res.add(new AnkietaDTO(a.getId(), a.getNazwa(), null)));
		return res;
	}

	public void deleteById(Long id) {
		ar.deleteById(id);
	}


	public List<AnkietaDTO> znajdzPoParentId(Long id) {
		Iterable<Ankieta> wszystkie = ar.findByRodzicId(id);
		List<AnkietaDTO> res = new ArrayList<>();
		wszystkie.forEach((a) -> res.add(new AnkietaDTO(a.getId(), a.getNazwa(), null)));
		return res;
	}


	public Optional<AnkietaDTO> znajdzPoId(Long id) {
		Optional<Ankieta> a = ar.findById(id);
		if (a.isPresent()) {
			return Optional.of(new AnkietaDTO(a.get().getId(), a.get().getNazwa(), null));
		}
		return Optional.empty();
	}

	@Transactional
	public void zmienNazwe(Long id, String nazwa) {
		Optional<Ankieta> ankieta = ar.findById(id);
		if (ankieta.isEmpty()) {
			throw new IllegalArgumentException("Niepoprawna ankieta");
		}
		ankieta.get().setNazwa(nazwa);
		ar.save(ankieta.get());
	}


	@Transactional
	public void dodajPytanie(Long id, String nazwa) {
		ar.save(new Ankieta(null, nazwa, new Ankieta(id, null, null)));
	}


	@Transactional
	public void dodajAnkiete(String nazwa) {
		ar.save(new Ankieta(null, nazwa, null));
	}
}
