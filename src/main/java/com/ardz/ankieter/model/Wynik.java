package com.ardz.ankieter.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  
@NoArgsConstructor 
@Table(name = "WYNIKI")
public class Wynik {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@ManyToOne
	private Ankieta ankieta;
	
	@ManyToOne
	private Osoba osoba;
	
	@Column(name = "WYNIK")
	private Integer wynik;
}
