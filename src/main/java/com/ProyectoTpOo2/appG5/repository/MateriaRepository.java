package com.ProyectoTpOo2.appG5.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ProyectoTpOo2.appG5.entity.Materia;

@Repository
public interface MateriaRepository extends CrudRepository<Materia, Long> {
	
	public List<Materia> findByCarrera(Long id);
}
