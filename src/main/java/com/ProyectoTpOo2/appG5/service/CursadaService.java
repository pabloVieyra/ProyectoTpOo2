package com.ProyectoTpOo2.appG5.service;

import com.ProyectoTpOo2.appG5.entity.Cursada;

public interface CursadaService {
	
	public Cursada crearCursada(Cursada cursada);
	
	public void borrarCursada(Long id) throws Exception;
	
	public Iterable<Cursada> traerCursadasActivas();
	
	public void actualizarCursada(Cursada cursada);
	
}
