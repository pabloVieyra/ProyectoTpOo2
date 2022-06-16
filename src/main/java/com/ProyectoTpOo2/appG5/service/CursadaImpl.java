package com.ProyectoTpOo2.appG5.service;

import java.util.List;
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
	public Cursada crearCursada(Cursada cursada) {
			cursada.setAprobado(false);	
		return repository.save(cursada);
	}

	@Override
	public void borrarCursada(Long id) throws Exception {
		Cursada cursada = repository.findCursadaById(id);
		if(cursada == null) throw new Exception("No se encontro el pedido");
		cursada.setEliminado(true);
		repository.save(cursada);
		
	}

	@Override
	public List<Cursada> traerCursadasActivas(){
		return repository.findByEliminado(false);
	}
	
	public void actualizarCursada(Cursada cursada) {
		 repository.save(cursada);
	}
	
	
}
