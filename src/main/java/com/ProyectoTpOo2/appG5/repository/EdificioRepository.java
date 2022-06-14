package com.ProyectoTpOo2.appG5.repository;




import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ProyectoTpOo2.appG5.entity.Edificio;

@Repository
public interface EdificioRepository extends CrudRepository<Edificio, Long>{
	
	public List<Edificio> findAllByOrderByNombreAsc();
	
	public Edificio findByid(Long id);	
}
