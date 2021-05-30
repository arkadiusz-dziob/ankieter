package com.ardz.ankieter.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.tomcat.util.security.MD5Encoder;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data  
@NoArgsConstructor 
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
	
	@ManyToOne
	private OsobaRola osobaRola;
	
	public void setHaslo(String haslo) {
		this.haslo = MD5Encoder.encode(haslo.getBytes());
	}
}
