package com.ProyectoTpOo2.appG5.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "final")
public class Final extends NotaPedido{
	

	@Column 
	@NotBlank
	private LocalDate fecha;
	
	@Column 
	@NotNull
	private int cantEstudiantes;
	
	@Column 
	@NotBlank
	private char turno;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Materia materia;

	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Profesor> profesores = new HashSet<>();
	
	public Final() {
		super();
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantEstudiantes() {
		return cantEstudiantes;
	}

	public void setCantEstudiantes(int cantEstudiantes) {
		this.cantEstudiantes = cantEstudiantes;
	}

	public char getTurno() {
		return turno;
	}

	public void setTurno(char turno) {
		this.turno = turno;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(Set<Profesor> profesores) {
		this.profesores = profesores;
	}

	@Override
	public String toString() {
		return "Final [fecha=" + fecha + ", cantEstudiantes=" + cantEstudiantes + ", turno=" + turno + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cantEstudiantes, fecha, turno);
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
		Final other = (Final) obj;
		return cantEstudiantes == other.cantEstudiantes && Objects.equals(fecha, other.fecha) && turno == other.turno;
	}

	
	
}
