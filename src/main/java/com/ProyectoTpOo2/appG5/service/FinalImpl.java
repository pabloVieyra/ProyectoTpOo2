package com.ProyectoTpOo2.appG5.service;

import java.util.List;
import java.util.Optional;
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
	public List<Final> getAllFinales(){
		return (List<Final>) repository.findAll();
	}

	public Optional<Final> traerFinalId(Long id){
		return repository.findById(id);
	}
	
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
	public Iterable<Final> getfinalesActivos(){
		return repository.findByEliminado(false);
		}
	
	public Final actualizarFinal(Final fin){
		return repository.save(fin);
	}
}
