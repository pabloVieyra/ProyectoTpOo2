package com.ProyectoTpOo2.appG5.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ProyectoTpOo2.appG5.entity.Tradicional;

@Repository
public interface TradicionalRepository extends CrudRepository<Tradicional, Long>{
	
	public List<Tradicional> findAllByOrderByEdificioAsc();
}
