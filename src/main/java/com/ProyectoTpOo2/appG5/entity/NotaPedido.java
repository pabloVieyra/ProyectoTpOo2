package com.ProyectoTpOo2.appG5.entity;

import java.util.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "notapedido")
public abstract class NotaPedido {

	
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
	
	@Column 
	@NotNull
    private String tipoAula;
	
	@Column 
	@NotNull
	private boolean conProyector;
	
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
	
	public String getTipoAula() {
		return tipoAula;
	}

	public void setTipoAula(String tipoAula) {
		this.tipoAula = tipoAula;
	}

	public boolean isConProyector() {
		return conProyector;
	}

	public void setConProyector(boolean conProyector) {
		this.conProyector = conProyector;
	}

	@Override
	public String toString() {
		return "NotaPedido [id=" + id + ", porcentaje=" + porcentaje + ", descripcion=" + descripcion + ", aprobado="
				+ aprobado + "]";
	}

	

	
	@Override
	public int hashCode() {
		return Objects.hash(aprobado, conProyector, descripcion, id, porcentaje, tipoAula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaPedido other = (NotaPedido) obj;
		return aprobado == other.aprobado && conProyector == other.conProyector
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& porcentaje == other.porcentaje && Objects.equals(tipoAula, other.tipoAula);
	}

	




}
