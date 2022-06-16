package com.ProyectoTpOo2.appG5.service;


import java.util.List;
import com.ProyectoTpOo2.appG5.entity.Edificio;


public interface EdificioService {
	
	public List<Edificio> traerEdificiosEnOrden();
	
	public Edificio traerPorId(Long id);
	
	public Edificio actualizarEdificio (Edificio edificio)throws Exception;
	
}
