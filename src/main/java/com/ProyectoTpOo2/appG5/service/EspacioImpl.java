package com.ProyectoTpOo2.appG5.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ProyectoTpOo2.appG5.entity.Aula;
import com.ProyectoTpOo2.appG5.entity.Cursada;
import com.ProyectoTpOo2.appG5.entity.Espacio;
import com.ProyectoTpOo2.appG5.entity.Final;
import com.ProyectoTpOo2.appG5.entity.Taller;
import com.ProyectoTpOo2.appG5.entity.Tradicional;
import com.ProyectoTpOo2.appG5.repository.EspacioRepository;


@Service
@Transactional
public class EspacioImpl implements EspacioService{

	@Autowired
	EspacioRepository espacioRepository;
	
	public Espacio agregar(LocalDate fecha, String turno, boolean libre, Aula aula) throws Exception{
		Espacio espacio = traerEspacio(fecha, turno, aula);
		if(espacio != null) throw new Exception();
		 espacio = new Espacio(fecha,turno,libre,aula);
		 espacioRepository.save(espacio);
	return espacio;
	}
	
	public void agregarEspacioPorMes(int mes, int anio, Aula aula) throws Exception{		 
		LocalDate fechaInicio = LocalDate.of(anio, mes, 1); 
		int ultimoDiaMes = fechaInicio.lengthOfMonth();
		LocalDate fechaFin = LocalDate.of(anio, mes, ultimoDiaMes); 
		List<String> turnos = new ArrayList<String>();
		turnos.add("maniana");
		turnos.add("tarde");
		turnos.add("noche");
		while(fechaInicio.isBefore(fechaFin.plusDays(1))){	
			Set<Espacio> espacios = new HashSet<Espacio>();
			for(int i = 0; i < 3; i ++) {
				espacios.add(this.agregar(fechaInicio, turnos.get(i), true,aula));	
			}
			aula.setEspacio(espacios);
			fechaInicio = fechaInicio.plusDays(1);
		}
	}
	
	public List<Espacio> traerEspacios(){
		return (List<Espacio>) espacioRepository.findAll();
	}

	public Espacio traerEspacio(LocalDate fecha, String turno, Aula aula){
		return espacioRepository.findEspacio(fecha, turno,aula.getId(),true);
	}

	public int CrearEspacios(Aula aula, boolean conProyector, String tipoAula, int cantEstudiantes, String turno, LocalDate fecha, long idNotaPedido) throws Exception {
		Espacio espacio = new Espacio();
		boolean taller = false; 
		if(tipoAula.equalsIgnoreCase("Taller")) {taller=true;}
			if((aula instanceof Taller) && taller) {
				((Taller)aula).esValida(cantEstudiantes, conProyector);
					   espacio = traerEspacio(fecha, turno, aula);
						if(espacio == null)throw new Exception("El aula no esta disponible");
							espacio.setLibre(false);
							espacio.setIdNotaPedido(idNotaPedido);
							espacioRepository.save(espacio);
			}else {
				((Tradicional)aula).esValida(cantEstudiantes, conProyector);
					 espacio = traerEspacio(fecha, turno, aula);
					if(espacio == null)throw new Exception("El aula no esta disponible");
					espacio.setLibre(false);
					espacio.setIdNotaPedido(idNotaPedido);
					espacioRepository.save(espacio);
			}
		return aula.getNumAula();
	}
	
	public int CrearEspaciosFinal(Aula aula, Final pedido) throws Exception{
		CrearEspacios( aula, pedido.isConProyector(),  pedido.getTipoAula(), pedido.getCantEstudiantes(),  pedido.getTurno(),  pedido.getFecha(), pedido.getId());
						
		return aula.getNumAula();
	}
	
	@Override
	public int CrearEspaciosCursada(Aula aula, Cursada pedido) throws Exception {
		int porcentaje = pedido.getPorcentaje();
		LocalDate inicio = pedido.getFechaInicio();
		if(porcentaje==25) {
			CrearEspacios( aula,  pedido.isConProyector(),  pedido.getTipoAula(),  pedido.getCurso().getCantEstudiantes(),  pedido.getCurso().getTurno(),  inicio.plusDays(56), pedido.getId());
			CrearEspacios( aula,  pedido.isConProyector(),  pedido.getTipoAula(),  pedido.getCurso().getCantEstudiantes(),  pedido.getCurso().getTurno(),  inicio.plusDays(105), pedido.getId());
		}
		if(porcentaje==50) {
			espaciosMitadCursada(aula,  pedido);
		}
		if(porcentaje==100) {
			espaciosCompletoCursada(aula, pedido);
		}
		return aula.getNumAula();
	}
	
	public int espaciosMitadCursada(Aula aula, Cursada pedido) throws Exception{
		LocalDate inicio = pedido.getFechaInicio();
		LocalDate fin = pedido.getFechaFin();
		while(inicio.isBefore(fin.plusDays(1))){	
			CrearEspacios( aula, pedido.isConProyector(),  pedido.getTipoAula(),  pedido.getCurso().getCantEstudiantes(),  pedido.getCurso().getTurno(),  inicio.plusDays(14), pedido.getId());	
			inicio = inicio.plusDays(14);
		}	
		return aula.getNumAula();
	}
	
	public int espaciosCompletoCursada(Aula aula, Cursada pedido) throws Exception{
		LocalDate inicio = pedido.getFechaInicio();
		LocalDate fin = pedido.getFechaFin();
		while(inicio.isBefore(fin.plusDays(1))){	
			CrearEspacios(aula, pedido.isConProyector(),  pedido.getTipoAula(),  pedido.getCurso().getCantEstudiantes(),  pedido.getCurso().getTurno(),   inicio.plusDays(1), pedido.getId());
			inicio = inicio.plusDays(1);
		}
		return aula.getNumAula();
	}

	@Override
	public List<Espacio> traerPorIdNotaPedido(long idNotaPedido){
		return espacioRepository.findByIdNotaPedido(idNotaPedido);
	}
		
	public List<Espacio> traerPorIdNotaPedidoActivo(){
		return espacioRepository.traerCargados();
	}
	
	}
