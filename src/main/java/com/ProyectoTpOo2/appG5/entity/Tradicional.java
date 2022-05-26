package com.ProyectoTpOo2.appG5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tradicional")
public class Tradicional extends Aula{
	@Column 
	@NotNull
	private int cantBancos;
	
	@Column 
	@NotBlank
	private char pizarron;//(t=tiza,f=fibron, etc)
	
	@Column 
	@NotNull
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

	public char getPizarron() {
		return pizarron;
	}

	public void setPizarron(char pizarron) {
		this.pizarron = pizarron;
	}

	public boolean isTieneProyector() {
		return tieneProyector;
	}

	public void setTieneProyector(boolean tieneProyector) {
		this.tieneProyector = tieneProyector;
	}

	@Override
	public String toString() {
		return "Tradicional [cantBancos=" + cantBancos + ", pizarron=" + pizarron + ", tieneProyector=" + tieneProyector
				+ "]";
	}
	
	
	
}
