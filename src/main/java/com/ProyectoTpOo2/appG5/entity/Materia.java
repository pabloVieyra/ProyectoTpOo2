package com.ProyectoTpOo2.appG5.entity;

import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "materia")
public class Materia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	@NotBlank
	private String Name;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Carrera carrera;

	@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY,mappedBy="id")
	private Set<Curso> cursos;
	
	@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY,mappedBy="id")
	private Set<Final> finales;
	
	public Materia() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Set<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(Set<Curso> cursos) {
		this.cursos = cursos;
	}

	public Set<Final> getFinales() {
		return finales;
	}

	public void setFinales(Set<Final> finales) {
		this.finales = finales;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", Name=" + Name + ", carrera=" + carrera + ", cursos=" + cursos + ", finales="
				+ finales + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Name, carrera, cursos, finales, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Materia other = (Materia) obj;
		return Objects.equals(Name, other.Name) && Objects.equals(carrera, other.carrera)
				&& Objects.equals(cursos, other.cursos) && Objects.equals(finales, other.finales)
				&& Objects.equals(id, other.id);
	}

	
	
	
}
