package com.ProyectoTpOo2.appG5.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "catedra")
public abstract class Catedra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	@NotBlank
	private String Name;

	@OneToOne(optional = true, cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy = "catedra")  
    private NotaPedido notaPedido;

	public Catedra() {
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

	public NotaPedido getNotaPedido() {
		return notaPedido;
	}

	public void setNotaPedido(NotaPedido notaPedido) {
		this.notaPedido = notaPedido;
	}

	@Override
	public String toString() {
		return "Catedra [id=" + id + ", Name=" + Name + ", notaPedido=" + notaPedido + "]";
	}

	
	
	
}
