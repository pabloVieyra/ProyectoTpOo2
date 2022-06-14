package com.ProyectoTpOo2.appG5.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ProyectoTpOo2.appG5.entity.Espacio;

@Repository
public interface EspacioRepository extends CrudRepository<Espacio, Long>{
	
	public  List<Espacio> findByAula(Long id);

	@Query(value = "select * from espacio e inner join aula a on e.aula_id = a.id where e.fecha= :fecha and e.turno = :turno and a.id = :id and e.libre= :libre", nativeQuery = true)
	public  Espacio findEspacio(@Param("fecha")LocalDate fecha, @Param("turno") String turno, @Param("id")Long idAula, @Param("libre")boolean libre);
	
	@Query(value = "select * from espacio e where e.id_nota_pedido > 0 order by e.fecha", nativeQuery = true)
	public  List<Espacio> traerCargados();
	
	public  List<Espacio> findByIdNotaPedido(long idNotaPedido);
	
}



















