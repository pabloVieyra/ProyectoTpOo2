package com.ProyectoTpOo2.appG5.service;


import java.util.List;
import java.util.Optional;

import com.ProyectoTpOo2.appG5.entity.Edificio;


public interface EdificioService {
	
	public List<Edificio> getAllEdificio();
	
	public List<Edificio> getEdificioEnOrden();
	
	public Edificio buscarPorId(Long id);
	
	public Edificio actualizar (Edificio edificio)throws Exception;
	
	
}
