package com.ProyectoTpOo2.appG5.service;

import java.time.LocalDate;
import java.util.ArrayList;
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
	public Espacio agregar(LocalDate fecha, String turno, boolean libre, Aula aula)throws Exception{
		//if(espacioRepository.traerEspacio(fecha, turno, aula) != null)throw new Exception("Error: no hay espacio disponible");
		Espacio espacio = new Espacio( fecha,  turno, libre, aula);
		espacioRepository.save(espacio);
	return espacio;
	}
	
	//genera espacios para el mes y el año enviados para un aula, si hay alguna excepcion significa que ya estan creados los espacios
	public void agregarEspacioMes(int mes, int anio, String turno, Aula aula) throws Exception{		
		int ultimoDiaMes = Funciones.traerCantDiasDeUnMes(anio,mes); 
		Set<Espacio> espacios = null;
		LocalDate fechaInicio = LocalDate.of(anio, mes, 1); 
		LocalDate fechaFin = LocalDate.of(anio, mes, ultimoDiaMes); 
		List<String> turnos = new ArrayList<String>();
		turnos.add("maniana");
		turnos.add("tarde");
		turnos.add("noche");
		while(fechaInicio.isBefore(fechaFin.plusDays(1))){	
			for(int i = 0; i < 3; i ++) {
			espacios.add(this.agregar(fechaInicio, turnos.get(i), true,aula));
			}
			fechaInicio = fechaInicio.plusDays(1);
			aula.setEspacio(espacios);
		}		
	}
	
	
	public Espacio traerEspacio(LocalDate fecha, String turno, Aula aula){
		return espacioRepository.findEspacio(fecha, turno,aula.getId(),true);
	}

	
	public int CrearEspaciosFinal(Aula aula, boolean conProyector, String tipoAula, int cantEstudiantes, String turno, LocalDate fecha) throws Exception {
		Espacio espacio = new Espacio();
		boolean taller = false; 
		boolean carga = false;
		if(tipoAula.equalsIgnoreCase("Taller")) {taller=true;}
			if((aula instanceof Taller) && taller) {
				if(((Taller)aula).getCantSillas() < cantEstudiantes) throw new Exception("El aula pedida no cuenta con la capacidad");
					   espacio = traerEspacio(fecha, turno, aula);
						if(espacio == null)throw new Exception("El aula no esta disponible");
							espacio.setLibre(false);
							espacioRepository.save(espacio);
			}else {
				if(((Tradicional)aula).getCantBancos() < cantEstudiantes && ((Tradicional)aula).isTieneProyector() != conProyector) throw new Exception("El aula pedida no cuenta con lo requerido");
					 espacio = traerEspacio(fecha, turno, aula);
					if(espacio == null)throw new Exception("El aula no esta disponible");
					espacio.setLibre(carga);
					espacioRepository.save(espacio);
			}
		return aula.getNumAula();
	}
		
	}
