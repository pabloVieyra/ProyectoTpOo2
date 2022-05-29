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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "curso")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	@NotNull
	private int codCurso;
	
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
	
	@OneToOne(optional = false, cascade = CascadeType.MERGE)  
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


	public Cursada getCursada() {
		return cursada;
	}


	public void setCursada(Cursada cursada) {
		this.cursada = cursada;
	}


	@Override
	public String toString() {
		return "Curso [id=" + id + ", codCurso=" + codCurso + ", cantEstudiantes=" + cantEstudiantes + ", turno="
				+ turno + ", materia=" + materia + ", profesores=" + profesores + ", cursada=" + cursada + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(cantEstudiantes, codCurso, cursada, id, materia, profesores, turno);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return cantEstudiantes == other.cantEstudiantes && codCurso == other.codCurso
				&& Objects.equals(cursada, other.cursada) && Objects.equals(id, other.id)
				&& Objects.equals(materia, other.materia) && Objects.equals(profesores, other.profesores)
				&& turno == other.turno;
	}

}
