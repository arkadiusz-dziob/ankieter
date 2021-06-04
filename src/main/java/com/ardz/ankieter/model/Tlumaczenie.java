package com.ardz.ankieter.model;

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
public class Tlumaczenie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(name = "ANKIETA_ID")
    private Long ankietaId;
	
	@Column(name = "LANG")
	private String lang;
	
	@Column(name = "TLUMACZENIE")
	private String tlumaczenie;
}
