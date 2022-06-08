package com.ProyectoTpOo2.appG5.service;

import java.util.List;

import com.ProyectoTpOo2.appG5.entity.Aula;
import com.ProyectoTpOo2.appG5.entity.Edificio;

public interface AulaService {
	public List<Aula> getAllAula();

	public List<Aula> traerPorEdificio(Edificio edificio);

	public List<Aula> traerPorEdificioEnOrden();

	public Aula getAula(int numAula);
	
	public Aula traerPorId(Long id);

}
