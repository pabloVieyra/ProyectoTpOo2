package com.ProyectoTpOo2.appG5.model;

import com.ProyectoTpOo2.appG5.entity.Aula;
import com.ProyectoTpOo2.appG5.entity.NotaPedido;

public class ModelPedido {

	private NotaPedido notaPedido;
	
	private Aula  aula;

	public ModelPedido(NotaPedido notaPedido, Aula aula) {
		super();
		this.notaPedido = notaPedido;
		this.aula = aula;
	}

	public ModelPedido() {
		super();
	}

	public NotaPedido getNotaPedido() {
		return notaPedido;
	}

	public void setNotaPedido(NotaPedido notaPedido) {
		this.notaPedido = notaPedido;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	@Override
	public String toString() {
		return "ModelPedido";
	}


	
}
