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
	public List<Edificio> getAllEdificio() {
		return (List<Edificio>) edificioRepository.findAll();
	}

	@Override
	public List<Edificio> getEdificioEnOrden() {
		return edificioRepository.findAllByOrderByNombreAsc();
	}
}
