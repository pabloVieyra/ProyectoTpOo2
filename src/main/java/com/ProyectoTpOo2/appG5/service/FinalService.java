package com.ProyectoTpOo2.appG5.service;

import java.util.Optional;
import com.ProyectoTpOo2.appG5.entity.Final;

public interface FinalService{

	public Iterable<Final> getAllFinales();
	
	public Final crearFinal(Final fin);
	
	public Optional<Final> traerFinalId(Long id);
	
	public void borrarFinal(Long id) throws Exception;
	
	public Iterable<Final> getfinalesActivos();
	
	public Final actualizarFinal(Final fin);
}
