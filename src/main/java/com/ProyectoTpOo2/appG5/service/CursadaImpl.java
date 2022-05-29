package com.ProyectoTpOo2.appG5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ProyectoTpOo2.appG5.entity.Cursada;
import com.ProyectoTpOo2.appG5.repository.CursadaRepository;

@Service
@Transactional
public class CursadaImpl implements CursadaService{

	
	@Autowired
	CursadaRepository repository;

	@Override
	public Iterable<Cursada> getAllCursadas() {
		
		return repository.findAll();
	}
}
