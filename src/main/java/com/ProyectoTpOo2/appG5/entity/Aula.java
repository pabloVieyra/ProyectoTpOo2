package com.ProyectoTpOo2.appG5.entity;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "aula")
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	@NotNull
	private int numAula;

	@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY,mappedBy="id")
	private Set<Espacio> espacio;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Edificio edificio;
	
	public Aula() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumAula() {
		return numAula;
	}

	public void setNumAula(int numAula) {
		this.numAula = numAula;
	}

	public Set<Espacio> getEspacio() {
		return espacio;
	}

	public void setEspacio(Set<Espacio> espacio) {
		this.espacio = espacio;
	}

	public Edificio getEdificio() {
		return edificio;
	}

	public void setEdificio(Edificio edificio) {
		this.edificio = edificio;
	}

	@Override
	public String toString() {
		return "Aula [id=" + id + ", numAula=" + numAula + ", espacio=" + espacio
				+ ", edificio=" + edificio + "]";
	}

}