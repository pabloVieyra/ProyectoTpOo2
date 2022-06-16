package com.ProyectoTpOo2.appG5.service;

import java.util.List;
import com.ProyectoTpOo2.appG5.entity.Aula;
import com.ProyectoTpOo2.appG5.entity.Cursada;
import com.ProyectoTpOo2.appG5.entity.Espacio;
import com.ProyectoTpOo2.appG5.entity.Final;

public interface EspacioService {

	public void agregarEspacioPorMes(int mes, int anio, Aula aula)throws Exception ;
	
	public int CrearEspaciosFinal(Aula aula, Final pedido) throws Exception;
	
	public int CrearEspaciosCursada(Aula aula, Cursada pedido) throws Exception;

	public List<Espacio> traerEspacios();

	public List<Espacio> traerPorIdNotaPedidoActivo();
	
	public List<Espacio> traerPorIdNotaPedido(long idNotaPedido);
	
	
}
