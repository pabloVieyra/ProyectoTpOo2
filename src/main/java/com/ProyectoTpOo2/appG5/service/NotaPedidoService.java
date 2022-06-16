package com.ProyectoTpOo2.appG5.service;

import java.util.List;
import com.ProyectoTpOo2.appG5.entity.NotaPedido;

public interface NotaPedidoService {
	
	public List<NotaPedido> TraerNotasPedido();
	
	public NotaPedido actualizarNotaPedido(NotaPedido notaPedido);
	
	public List<NotaPedido> TraerNotasPedidoPendientes();
}
