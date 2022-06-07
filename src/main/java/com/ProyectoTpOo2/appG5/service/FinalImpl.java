package com.ProyectoTpOo2.appG5.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ProyectoTpOo2.appG5.entity.Final;
import com.ProyectoTpOo2.appG5.repository.FinalRepository;

@Service
@Transactional
public class FinalImpl implements FinalService{

	@Autowired
	FinalRepository repository;
	
	@Override
	public Iterable<Final> getAllFinales() {
		return repository.findAll();
	}


}