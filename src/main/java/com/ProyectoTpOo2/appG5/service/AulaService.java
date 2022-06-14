package com.ProyectoTpOo2.appG5.service;

import java.util.List;
import com.ProyectoTpOo2.appG5.entity.Aula;


public interface AulaService {

    public List<Aula> traerPorEdificioEnOrden();
	
	public Aula traerPorId(Long id);

}
