package com.ProyectoTpOo2.appG5.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private int codCurso;
	
	@Column 
	private int cantEstudiantes;
	
	@Column 
	private String turno;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Materia materia;


	@ManyToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private Set<Profesor> profesores = new HashSet<>();
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "curso")
    private Cursada cursada;

	
	public Curso() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getCodCurso() {
		return codCurso;
	}


	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}


	public int getCantEstudiantes() {
		return cantEstudiantes;
	}


	public void setCantEstudiantes(int cantEstudiantes) {
		this.cantEstudiantes = cantEstudiantes;
	}


	public String getTurno() {
		return turno;
	}


	public void setTurno(String turno) {
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


	public Cursada getCursada() {
		return cursada;
	}


	public void setCursada(Cursada cursada) {
		this.cursada = cursada;
	}


	@Override
	public String toString() {
		return "Curso [id=" + id + ", codCurso=" + codCurso + ", cantEstudiantes=" + cantEstudiantes + ", turno="
				+ turno + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(cantEstudiantes, codCurso, cursada, id, materia, profesores, turno);
	}


	
	public boolean equals(Curso curso) {
		boolean igual = false;
		if(this.id == curso.getId() || this.codCurso == curso.getCodCurso()) igual = true;
		return igual;
	}
}
