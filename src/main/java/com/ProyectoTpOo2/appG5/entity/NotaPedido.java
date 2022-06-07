package com.ProyectoTpOo2.appG5.entity;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "notapedido")
public class NotaPedido{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column
	private String descripcion;
	
	@Column 
	private String edificio;
	
	@Column 
	private boolean aprobado;
	
	@Column 
    private String tipoAula;
	
	@Column 
	private boolean conProyector;
	
	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
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
	
	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	
	
	public String getEdificio() {
		return edificio;
	}

	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}

	@Override
	public String toString() {
		return "NotaPedido [id=" + id + ", descripcion=" + descripcion + ", aprobado="
				+ aprobado + "]";
	}

	

	
	@Override
	public int hashCode() {
		return Objects.hash(aprobado, conProyector, descripcion, id, tipoAula);
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
				&& Objects.equals(tipoAula, other.tipoAula);
	}

	




}
