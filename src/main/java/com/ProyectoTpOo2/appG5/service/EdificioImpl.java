package com.ProyectoTpOo2.appG5.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ProyectoTpOo2.appG5.entity.Edificio;
import com.ProyectoTpOo2.appG5.repository.EdificioRepository;

@Service
@Transactional
public class EdificioImpl implements EdificioService{

	@Autowired
	EdificioRepository edificioRepository;

	@Override
	public List<Edificio> traerEdificiosEnOrden() {
		return edificioRepository.findAllByOrderByNombreAsc();
	}

	@Override
	public Edificio traerPorId(Long id) {	
		return edificioRepository.findByid(id);
	}

	@Override
	public Edificio actualizarEdificio(Edificio edificio) throws Exception {
		if(edificio==null) throw new Exception("El edificio no ha sido encontrado");	
		return edificioRepository.save(edificio);
	}
	
	
}
