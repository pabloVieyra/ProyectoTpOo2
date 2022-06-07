package com.ProyectoTpOo2.appG5.service;

import com.ProyectoTpOo2.appG5.entity.Cursada;


public interface CursadaService {
	
	public Iterable<Cursada> getAllCursadas();

	public Cursada crearCursada(Cursada cursada);
}
