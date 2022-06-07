package com.ProyectoTpOo2.appG5.repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ProyectoTpOo2.appG5.entity.Curso;


@Repository
public interface CursoRepository extends CrudRepository<Curso, Long>{
	public List<Curso> findByCursadaIsNull();
}
