package com.ardz.ankieter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "KOMENTARZE")
public class Komentarz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@ManyToOne
	private Ankieta ankieta;
	
	@ManyToOne
	private Osoba osoba;
	
	@Column(name = "KOMENTARZ", length = 1000)
	private String komentarz;
}
