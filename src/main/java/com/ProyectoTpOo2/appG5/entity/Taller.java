package com.ProyectoTpOo2.appG5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "taller")
public class Taller extends Aula{

	@Column 
	private int cantPc;
	
	@Column 
	private boolean tieneProyector;
	
	@Column 
	private int cantSillas;

	public Taller() {
		super();
	}

	public int getCantPc() {
		return cantPc;
	}

	public void setCantPc(int cantPc) {
		this.cantPc = cantPc;
	}

	public int getCantSillas() {
		return cantSillas;
	}

	public void setCantSillas(int cantSillas) {
		this.cantSillas = cantSillas;
	}
	
	public boolean isTieneProyector() {
		return tieneProyector;
	}

	public void setTieneProyector(boolean tieneProyector) {
		this.tieneProyector = tieneProyector;
	}

	@Override
	public String toString() {
		return "Taller [cantPc=" + cantPc + ", cantSillas=" + cantSillas + "]";
	}
		
	 //para validar en espacio 
	public void esValida(int cantEstudiantes, boolean conProyector) throws Exception {
		if (this.getCantSillas() < cantEstudiantes && conProyector != this.tieneProyector)
			throw new Exception("El aula pedida no cuenta con la capacidad");
		
	}
	
}

