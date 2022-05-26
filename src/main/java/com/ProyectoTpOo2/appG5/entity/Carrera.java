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
@Table(name = "carrera")
public class Carrera {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	@NotBlank
	private String Name;
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Departamento departamento;

	@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY,mappedBy="id")
	private Set<Materia> materias;

	public Carrera() {
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

	public Departamento getDepartment() {
		return departamento;
	}

	public void setDepartment(Departamento departamento) {
		this.departamento = departamento;
	}

	public Set<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(Set<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public String toString() {
		return "Carrera [id=" + id + ", Name=" + Name + ", Departamento=" + departamento + ", materias=" + materias + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(departamento, Name, id, materias);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carrera other = (Carrera) obj;
		return Objects.equals(departamento, other.departamento) && Objects.equals(Name, other.Name)
				&& Objects.equals(id, other.id) && Objects.equals(materias, other.materias);
	}
	
	
	





	
}
