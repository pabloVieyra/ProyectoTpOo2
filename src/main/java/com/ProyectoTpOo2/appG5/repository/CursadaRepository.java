package com.ProyectoTpOo2.appG5.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ProyectoTpOo2.appG5.entity.Cursada;


@Repository
public interface CursadaRepository extends CrudRepository<Cursada, Long>{

	public  Cursada findCursadaById(Long id);
	
	public   List<Cursada> findByEliminado(boolean eliminado);
	
}
