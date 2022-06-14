package com.ProyectoTpOo2.appG5.service;

import com.ProyectoTpOo2.appG5.entity.Final;

public interface FinalService{
	
	public Final crearFinal(Final fin);
	
	public void borrarFinal(Long id) throws Exception;
	
	public Iterable<Final> traerFinalesActivos();
	
	public void actualizarFinal(Final fin);
	
}
