package com.ardz.ankieter.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardz.ankieter.data.AnkietaDTO;
import com.ardz.ankieter.data.repositories.AnkietyRepository;
import com.ardz.ankieter.model.Ankieta;

@Service
public class AnkietyService {
	
	@Autowired
	private AnkietyRepository ar;
	
	public void saveOrUpdate(AnkietaDTO ankietaDTO) {
		Ankieta ankieta = null;
		if (ankietaDTO.getId() != null) {
			Optional<Ankieta> oa = ar.findById(ankietaDTO.getId());
			if (oa.isPresent()) {
				ankieta = oa.get();
				ankieta.setNazwa(ankietaDTO.getNazwa());
				updateParent(ankietaDTO, ankieta);
			} else {
				throw new IllegalArgumentException("Ankieta with ID " + ankietaDTO.getId() + " does not exist.");
			}
		} else {
			ankieta = new Ankieta();
			ankieta.setNazwa(ankietaDTO.getNazwa());
			updateParent(ankietaDTO, ankieta);
		}
		if (ankieta != null) {
			ar.save(ankieta);
		}
	}

	private void updateParent(AnkietaDTO ankietaDTO, Ankieta ankieta) {
		if (ankietaDTO.getId_ankiety() != null) {
			Optional<Ankieta> rodzic = ar.findById(ankietaDTO.getId_ankiety());
			ankieta.setRodzic(rodzic.orElseGet(null));
		}
	}

	public List<AnkietaDTO> wszystkie() {
		Iterable<Ankieta> wszystkie = ar.findAll();
		List<AnkietaDTO> res = new ArrayList<>();
		if (wszystkie != null) {
			for (Ankieta a : wszystkie) {
				res.add(new AnkietaDTO(a.getId(), a.getNazwa(), (a.getRodzic() != null)? a.getRodzic().getId() : null));
			}
		}
		return res;
	}
}
