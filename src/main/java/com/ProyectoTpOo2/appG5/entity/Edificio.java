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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "edificio")
public class Edificio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	private String nombre;
	
	
	@OneToMany(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY,mappedBy="id")
	private Set<Aula> aula;

	public Edificio() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<Aula> getAula() {
		return aula;
	}

	public void setAula(Set<Aula> aula) {
		this.aula = aula;
	}

	@Override
	public String toString() {
		return "Edificio [id=" + id + ", nombre=" + nombre +"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edificio other = (Edificio) obj;
		return Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	
	
}
