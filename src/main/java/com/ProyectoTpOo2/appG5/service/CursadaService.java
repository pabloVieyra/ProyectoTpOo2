package com.ProyectoTpOo2.appG5.service;

import java.util.Optional;
import com.ProyectoTpOo2.appG5.entity.Cursada;

public interface CursadaService {
	
	public Iterable<Cursada> getAllCursadas();

	public Cursada crearCursada(Cursada cursada);
	
	public void borrarCursada(Long id) throws Exception;
	
	public Optional<Cursada> traerCursadaId(Long id);
	
	public Iterable<Cursada> getCursadasActivas();
	
	public Cursada actualizarCursada(Cursada cursada);
}
