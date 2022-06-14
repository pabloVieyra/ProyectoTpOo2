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
	public Final crearFinal(Final fin){
			fin.setAprobado(false);
		return repository.save(fin);
		
	}
	
	public void borrarFinal(Long id) throws Exception{
		Final fin = repository.findFinalById(id);
		if(fin == null) throw new Exception("No se encontro el pedido");
		fin.setEliminado(true);
		repository.save(fin);
	}
	
	@Override
	public Iterable<Final> traerFinalesActivos(){
		return repository.findByEliminado(false);
		}
	
	public void actualizarFinal(Final fin) {
		repository.save(fin);
	}
}
