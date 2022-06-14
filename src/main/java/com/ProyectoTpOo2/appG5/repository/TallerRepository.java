package com.ProyectoTpOo2.appG5.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ProyectoTpOo2.appG5.entity.Taller;

@Repository
public interface TallerRepository extends CrudRepository<Taller, Long>{
	
	public List<Taller> findAllTallerByOrderByEdificioAsc();
	
	
}
