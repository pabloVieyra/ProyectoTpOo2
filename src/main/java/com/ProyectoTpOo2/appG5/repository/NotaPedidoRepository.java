package com.ProyectoTpOo2.appG5.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ProyectoTpOo2.appG5.entity.NotaPedido;

public interface NotaPedidoRepository extends CrudRepository<NotaPedido, Long>{
	
	public  NotaPedido findNotaPedidoById(Long id);
	
	public  List<NotaPedido> findAll();
	
	public  List<NotaPedido> findNotaPedidoByAprobado(boolean aprobado);
	
}
