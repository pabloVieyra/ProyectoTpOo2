package com.ProyectoTpOo2.appG5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ProyectoTpOo2.appG5.entity.Edificio;
import com.ProyectoTpOo2.appG5.repository.EdificioRepository;

import net.bytebuddy.implementation.bytecode.Throw;


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

	@Override
	public Edificio buscarPorId(Long id) {
		
		return edificioRepository.findByid(id);
	}

	@Override
	public Edificio actualizar(Edificio edificio) throws Exception {
		if(edificio==null) throw new Exception("El edificio no ha sido encontrado");
		
		return edificioRepository.save(edificio);
	}
	
	
}
