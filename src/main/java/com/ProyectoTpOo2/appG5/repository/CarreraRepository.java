package com.ProyectoTpOo2.appG5.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ProyectoTpOo2.appG5.entity.Carrera;


@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long>{

}
