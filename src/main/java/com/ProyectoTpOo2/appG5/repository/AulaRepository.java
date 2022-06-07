package com.ProyectoTpOo2.appG5.repository;


import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ProyectoTpOo2.appG5.entity.Aula;
import com.ProyectoTpOo2.appG5.entity.Edificio;



@Repository
public interface AulaRepository extends CrudRepository<Aula, Long>{
	
	public  List<Aula> findByEdificio(Edificio edificio);
	
	public  Aula findByNumAula(int numAula);
	
	public List<Aula> findAllByOrderByEdificioAsc();
}