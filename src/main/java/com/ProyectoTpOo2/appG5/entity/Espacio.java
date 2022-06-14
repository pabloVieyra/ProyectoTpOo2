package com.ProyectoTpOo2.appG5.entity;

import java.time.LocalDate;
import java.util.Objects;

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
	
	@Column
	private long idNotaPedido;
	
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
	
	public Espacio(LocalDate fecha, String turno, boolean libre, long idNotaPedido, Aula aula) {
		super();
		this.fecha = fecha;
		this.turno = turno;
		this.libre = libre;
		this.idNotaPedido = idNotaPedido;
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

	public long getIdNotaPedido() {
		return idNotaPedido;
	}

	public void setIdNotaPedido(long idNotaPedido) {
		this.idNotaPedido = idNotaPedido;
	}



	@Override
	public String toString() {
		return "Espacio [id=" + id + ", fecha=" + fecha + ", turno=" + turno + ", libre=" + libre + ", idNotaPedido="
				+ idNotaPedido + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(fecha, id, idNotaPedido, libre, turno);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espacio other = (Espacio) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(id, other.id) && idNotaPedido == other.idNotaPedido
				&& libre == other.libre && Objects.equals(turno, other.turno);
	}
	
	


	
	
}
