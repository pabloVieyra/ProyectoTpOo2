package com.ProyectoTpOo2.appG5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProyectoTpOo2.appG5.entity.Aula;
import com.ProyectoTpOo2.appG5.entity.Edificio;
import com.ProyectoTpOo2.appG5.repository.AulaRepository;
import com.ProyectoTpOo2.appG5.repository.EspacioRepository;

@Service
@Transactional
public class AulaImpl implements AulaService {
	
	@Autowired
	AulaRepository repository;

	@Autowired
	EspacioRepository espacioRepository;

	public List<Aula> getAllAula() {
		return (List<Aula>) repository.findAll();
	}

	public List<Aula> traerPorEdificio(Edificio edificio) {
		return (List<Aula>) repository.findByEdificio(edificio);
	}

	public Aula getAula(int numAula) {
		return repository.findByNumAula(numAula);
	}

	@Override
	public List<Aula> traerPorEdificioEnOrden() {
		return repository.findAllByOrderByEdificioAsc();
	}

	@Override
	public Aula traerPorId(Long id) {
		return repository.findAulaById(id);
	}
	
}
