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
import com.ProyectoTpOo2.appG5.entity.Espacio;
import com.ProyectoTpOo2.appG5.entity.Taller;
import com.ProyectoTpOo2.appG5.entity.Tradicional;
import com.ProyectoTpOo2.appG5.repository.EspacioRepository;


@Service
@Transactional
public class EspacioImpl implements EspacioService{

	@Autowired
	EspacioRepository espacioRepository;
	
	//si no existe genera espacio para un aula y una fecha especifica
	public Espacio agregar(LocalDate fecha, String turno, boolean libre, Aula aula) throws Exception{
		Espacio espacio = traerEspacio(fecha, turno, aula);
		if(espacio != null) throw new Exception();
		 espacio = new Espacio( fecha,  turno, libre, aula);
		 espacioRepository.save(espacio);
	return espacio;
	}
	
	//genera espacios para el mes y el año enviados para un aula, si hay alguna excepcion significa que ya estan creados los espacios
	public void agregarEspacioMes(int mes, int anio, Aula aula) throws Exception{		 
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

	public int CrearEspacios(Aula aula, boolean conProyector, String tipoAula, int cantEstudiantes, String turno, LocalDate fecha) throws Exception {
		Espacio espacio = new Espacio();
		boolean taller = false; 
		boolean carga = false;
		if(tipoAula.equalsIgnoreCase("Taller")) {taller=true;}
			if((aula instanceof Taller) && taller) {
				((Taller)aula).esValida(cantEstudiantes, conProyector);
					   espacio = traerEspacio(fecha, turno, aula);
						if(espacio == null)throw new Exception("El aula no esta disponible");
							espacio.setLibre(false);
							espacioRepository.save(espacio);
			}else {
				((Tradicional)aula).esValida(cantEstudiantes, conProyector);
					 espacio = traerEspacio(fecha, turno, aula);
					if(espacio == null)throw new Exception("El aula no esta disponible");
					espacio.setLibre(carga);
					espacioRepository.save(espacio);
			}
		return aula.getNumAula();
	}
	
	public int CrearEspaciosFinal(Aula aula, boolean conProyector, String tipoAula, int cantEstudiantes, String turno, LocalDate fecha) throws Exception{
		CrearEspacios( aula,  conProyector,  tipoAula,  cantEstudiantes,  turno,  fecha);
		return aula.getNumAula();
	}
	
	@Override
	public List<LocalDate> CrearEspaciosCursada(Aula aula, boolean conProyector, String tipoAula, int cantEstudiantes, String turno,
			LocalDate inicio, LocalDate fin, int porcentaje) throws Exception {
		List<LocalDate> fechas = new ArrayList<LocalDate>();
		if(porcentaje==25) {
			CrearEspacios( aula,  conProyector,  tipoAula,  cantEstudiantes,  turno,  inicio.plusDays(56));
			CrearEspacios( aula,  conProyector,  tipoAula,  cantEstudiantes,  turno,  inicio.plusDays(105));
		}
		if(porcentaje==50) {
			espaciosMitadCursada( aula,  conProyector,  tipoAula,  cantEstudiantes,  turno, inicio,  fin,  porcentaje);
		}
		if(porcentaje==100) {
			espaciosCompletoCursada( aula,  conProyector,  tipoAula,  cantEstudiantes,  turno, inicio,  fin,  porcentaje);
		}
		
		return fechas;
	}
	
	public List<LocalDate> espaciosMitadCursada(Aula aula, boolean conProyector, String tipoAula, int cantEstudiantes, String turno,
			LocalDate inicio, LocalDate fin, int porcentaje) throws Exception{
		List<LocalDate> fechas = new ArrayList<LocalDate>();
		while(inicio.isBefore(fin.plusDays(1))){	
			CrearEspacios( aula,  conProyector,  tipoAula,  cantEstudiantes,  turno,  inicio.plusDays(14));	
			inicio = inicio.plusDays(14);
		}	
		return fechas;
	}
	
	public List<LocalDate> espaciosCompletoCursada(Aula aula, boolean conProyector, String tipoAula, int cantEstudiantes, String turno,
			LocalDate inicio, LocalDate fin, int porcentaje) throws Exception{
		List<LocalDate> fechas = new ArrayList<LocalDate>();
		while(inicio.isBefore(fin.plusDays(1))){	
			CrearEspacios( aula,  conProyector,  tipoAula,  cantEstudiantes,  turno,  inicio.plusDays(1));
			inicio = inicio.plusDays(1);
		}
		return fechas;
	}
	
	
		
	}
