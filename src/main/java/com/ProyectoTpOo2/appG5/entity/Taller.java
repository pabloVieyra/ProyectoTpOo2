package com.ProyectoTpOo2.appG5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "taller")
public class Taller extends Aula{

	@Column 
	@NotNull
	private int cantPc;
	
	@Column 
	@NotNull
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

	@Override
	public String toString() {
		return "Taller [cantPc=" + cantPc + ", cantSillas=" + cantSillas + "]";
	}
		
	
}

