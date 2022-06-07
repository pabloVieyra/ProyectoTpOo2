package com.ProyectoTpOo2.appG5.entity;

import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "espacio")
public class Espacio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private LocalDate fecha;
	
	@Column 
	private String turno;
	
	@Column 
	private boolean libre;
	

	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Aula aula;

	public Espacio() {
		super();
	}

	
	
	public Espacio(LocalDate fecha, String turno, boolean libre, Aula aula) {
		super();
		this.fecha = fecha;
		this.turno = turno;
		this.libre = libre;
		this.aula = aula;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public boolean isLibre() {
		return libre;
	}

	public void setLibre(boolean libre) {
		this.libre = libre;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	@Override
	public String toString() {
		return "Espacio [id=" + id + ", fecha=" + fecha + ", turno=" + turno + ", libre=" + libre + "]";
	}
	
}
