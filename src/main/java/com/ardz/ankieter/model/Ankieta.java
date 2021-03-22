package com.ardz.ankieter.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data  
@Table(name = "ANKIETY")
public class Ankieta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	@Column(length = 255, name = "NAZWA")
	private String nazwa;
	
    @ManyToOne
    private Ankieta rodzic;
    
    public Ankieta() {}
    		
    public Ankieta(Long id, String nazwa, Ankieta rodzic) {
		super();
		this.id = id;
		this.nazwa = nazwa;
		this.rodzic = rodzic;
	}

    @OneToMany(mappedBy="rodzic")
    private Set<Ankieta> pytania = new HashSet<Ankieta>();
    
	public Long getId() {
		return id;
	}

	public String getNazwa() {
		return nazwa;
	}

	public Ankieta getRodzic() {
		return rodzic;
	}

	public Set<Ankieta> getPytania() {
		return pytania;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}

	public void setRodzic(Ankieta rodzic) {
		this.rodzic = rodzic;
	}

	public void setPytania(Set<Ankieta> pytania) {
		this.pytania = pytania;
	}
	
}
