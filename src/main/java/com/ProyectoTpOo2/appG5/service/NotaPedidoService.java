package com.ProyectoTpOo2.appG5.service;

import java.util.List;
import java.util.Optional;
import com.ProyectoTpOo2.appG5.entity.NotaPedido;

public interface NotaPedidoService {
	
	public Optional<NotaPedido> traerNotaPedidoId(Long id)throws Exception;
	
	public void borrarNotaPedido(Long id) throws Exception;
	
	public List<NotaPedido> TraerNotaPedidos();
	
	public NotaPedido crearNotaPedido(NotaPedido notaPedido);
}
