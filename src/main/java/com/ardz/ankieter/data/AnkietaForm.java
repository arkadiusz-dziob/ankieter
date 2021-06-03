package com.ardz.ankieter.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AnkietaForm {

	public Long id;
	@NotNull
	@Size(min = 1, max = 255)
	public String nazwa;
	public Long id_ankiety;
	
	public AnkietaForm(Long id, String nazwa, Long id_ankiety) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.id_ankiety = id_ankiety;
	}

	public AnkietaForm() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public Long getId_ankiety() {
		return id_ankiety;
	}

	public void setId_ankiety(Long id_ankiety) {
		this.id_ankiety = id_ankiety;
	}

	
}
