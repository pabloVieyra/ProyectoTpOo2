package com.ProyectoTpOo2.appG5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ProyectoTpOo2.appG5.entity.NotaPedido;
import com.ProyectoTpOo2.appG5.repository.NotaPedidoRepository;


@Service
@Transactional
public class NotaPedidoImpl implements NotaPedidoService{
	
	@Autowired
	NotaPedidoRepository repository;
	
	
	@Override
	public Optional<NotaPedido> traerNotaPedidoId(Long id) throws Exception {
		Optional<NotaPedido> notaPedido = repository.findById(id);
		if(notaPedido == null) throw new Exception("No se encontro el pedido");
		return notaPedido;
	}

	@Override
	public void borrarNotaPedido(Long id) throws Exception {
		NotaPedido notaPedido = repository.findNotaPedidoById(id);
		if(notaPedido == null) throw new Exception("No se encontro el pedido");
		notaPedido.setEliminado(true);
		repository.save(notaPedido);	
	}

	@Override
	public List<NotaPedido> TraerNotaPedidos(){
		return repository.findAll();	
	}

	@Override
	public NotaPedido crearNotaPedido(NotaPedido notaPedido) {
		notaPedido.setAprobado(false);	
		return repository.save(notaPedido);
	}
	
}
