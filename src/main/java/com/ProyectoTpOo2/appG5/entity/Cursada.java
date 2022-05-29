package com.ProyectoTpOo2.appG5.entity;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;




@Entity
@Table(name = "cursada")
public class Cursada extends NotaPedido{
	
	
	
	@Column 
	@NotBlank
	private LocalDate fechaInicio;
	
	@Column 
	@NotBlank
	private LocalDate fechaFin;
	
	@OneToOne(optional = true, cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "cursada")  
    private Curso curso;

	public Cursada() {
		super();
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Cursada [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", curso=" + curso + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(curso, fechaFin, fechaInicio);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cursada other = (Cursada) obj;
		return Objects.equals(curso, other.curso) && Objects.equals(fechaFin, other.fechaFin)
				&& Objects.equals(fechaInicio, other.fechaInicio);
	}

	
	
	
}