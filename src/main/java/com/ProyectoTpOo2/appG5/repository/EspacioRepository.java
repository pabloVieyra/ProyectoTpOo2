package com.ProyectoTpOo2.appG5.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ProyectoTpOo2.appG5.entity.Aula;
import com.ProyectoTpOo2.appG5.entity.Espacio;

@Repository
public interface EspacioRepository extends CrudRepository<Espacio, Long>{
	public  List<Espacio> findByAula(Long id);

	@Query(value = "SELECT * FROM espacio e inner join aula a on e.aula_id = :aula WHERE e.fecha= :fecha and e.turno = :turno and e.libre = true", nativeQuery = true)
	public  Espacio findEspacioByFechaAndTurnoAndAula(@Param("fecha")LocalDate fecha, @Param("turno") String turno, @Param("aula")Aula aula);
	
	
}

















