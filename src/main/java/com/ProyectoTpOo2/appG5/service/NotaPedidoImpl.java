package com.ProyectoTpOo2.appG5.service;

import java.util.List;
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
	public List<NotaPedido> TraerNotasPedido(){
		return repository.findAll();	
	}

	@Override
	public NotaPedido actualizarNotaPedido(NotaPedido notaPedido) {
		return repository.save(notaPedido);
	}
}
