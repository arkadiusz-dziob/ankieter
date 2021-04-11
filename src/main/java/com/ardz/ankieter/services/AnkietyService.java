package com.ardz.ankieter.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ardz.ankieter.data.AnkietaForm;
import com.ardz.ankieter.data.repositories.AnkietyRepository;
import com.ardz.ankieter.model.Ankieta;

@Service
public class AnkietyService {
	
	@Autowired
	private AnkietyRepository ar;
	
	public void saveOrUpdate(AnkietaForm ankietaDTO) {
		ar.addOrUpdateAnkieta(ankietaDTO.getId(), ankietaDTO.getNazwa(), ankietaDTO.getId_ankiety());
	}

	public List<AnkietaForm> wszystkie() {
		Iterable<Ankieta> wszystkie = ar.findAll();
		List<AnkietaForm> res = new ArrayList<>();
		wszystkie.forEach((a) -> res.add(new AnkietaForm(a.getId(), a.getNazwa(), (a.getRodzic() != null)? a.getRodzic().getId() : null)));
		return res;
	}

	public void deleteById(Long id) {
		ar.deleteById(id);
	}
}
