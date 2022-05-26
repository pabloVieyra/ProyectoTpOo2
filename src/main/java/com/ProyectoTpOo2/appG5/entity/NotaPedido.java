package com.ProyectoTpOo2.appG5.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "notapedido")
public class NotaPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column 
	@NotNull
	private int porcentaje;
	
	@Column 
	private String descripcion;
	
	@Column 
	@NotNull
	private boolean aprobado;
	
	@OneToOne(optional = false, cascade = CascadeType.MERGE)  
    private Catedra catedra;
	
	@OneToOne(optional = false, cascade = CascadeType.MERGE)  
    private Aula aula;
	
	public NotaPedido() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPorcentaje() {
		return porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public Catedra getCatedra() {
		return catedra;
	}

	public void setCatedra(Catedra catedra) {
		this.catedra = catedra;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isAprobado() {
		return aprobado;
	}

	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}

	@Override
	public String toString() {
		return "NotaPedido [id=" + id + ", porcentaje=" + porcentaje + ", descripcion=" + descripcion + ", aprobado="
				+ aprobado + ", catedra=" + catedra + ", aula=" + aula + "]";
	}

}
