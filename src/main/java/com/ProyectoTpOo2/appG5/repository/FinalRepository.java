package com.ProyectoTpOo2.appG5.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ProyectoTpOo2.appG5.entity.Final;


@Repository
public interface FinalRepository extends CrudRepository<Final, Long>{

	public  Final findFinalById(Long id);
	
	public  List<Final> findByEliminado(boolean eliminado);
}

