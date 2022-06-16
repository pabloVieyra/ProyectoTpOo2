package com.ProyectoTpOo2.appG5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tradicional")
public class Tradicional extends Aula{
	
	@Column 
	private int cantBancos;
	
	@Column 
	private boolean tieneProyector;

	public Tradicional() {
		super();
	}

	public int getCantBancos() {
		return cantBancos;
	}

	public void setCantBancos(int cantBancos) {
		this.cantBancos = cantBancos;
	}


	public boolean isTieneProyector() {
		return tieneProyector;
	}

	public void setTieneProyector(boolean tieneProyector) {
		this.tieneProyector = tieneProyector;
	}

	@Override
	public String toString() {
		return "Tradicional [cantBancos=" + cantBancos + ", tieneProyector=" + tieneProyector
				+ "]";
	}
	
	//para validar en espacio 
	public void esValida(int cantEstudiantes, boolean conProyector) throws Exception {
		if (getCantBancos() < cantEstudiantes && isTieneProyector() != conProyector)throw new Exception("El aula pedida no cuenta con lo requerido");
		}
		
	
	
	
}
