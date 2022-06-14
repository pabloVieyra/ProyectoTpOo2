package com.ProyectoTpOo2.appG5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ProyectoTpOo2.appG5.entity.Aula;
import com.ProyectoTpOo2.appG5.repository.AulaRepository;

@Service
@Transactional
public class AulaImpl implements AulaService {
	
	@Autowired
	AulaRepository repository;

	@Override
	public List<Aula> traerPorEdificioEnOrden() {
		return repository.findAllByOrderByEdificioAsc();
	}

	@Override
	public Aula traerPorId(Long id) {
		return repository.findAulaById(id);
	}
	
}
