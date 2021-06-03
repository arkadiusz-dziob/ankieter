package com.ardz.ankieter.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  
@NoArgsConstructor 
@AllArgsConstructor
@Table(name = "OSOBY")
public class Osoba {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name = "DATA")
	private LocalDate data;
	
	@Column(name = "NAZWA", length = 45)
	private String nazwa;
	
	@Column(name = "HASLO")
	private String haslo;
	
	@Column(name = "ROLA")
	private String rola;
	
}
