package com.ProyectoTpOo2.appG5.repository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ProyectoTpOo2.appG5.entity.Aula;

@Repository
public interface AulaRepository extends CrudRepository<Aula, Long>{
		
	public List<Aula> findAllByOrderByEdificioAsc();
	
	public  Aula findAulaById(Long id);
}