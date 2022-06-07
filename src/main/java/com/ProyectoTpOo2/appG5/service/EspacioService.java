package com.ProyectoTpOo2.appG5.service;

import java.time.LocalDate;
import com.ProyectoTpOo2.appG5.entity.Aula;
import com.ProyectoTpOo2.appG5.entity.Espacio;

public interface EspacioService {

	public Espacio agregar(LocalDate fecha, String turno, boolean libre, Aula aula)throws Exception;
	
	public void agregarEspacioMes(int mes, int anio, String turno, Aula aula) throws Exception;
	
	public Espacio traerEspacio(LocalDate fecha, String turno, Aula aula);
	
	public int CrearEspaciosFinal(Aula aula, boolean conProyector, String tipoAula,int cantEstudiantes, String turno, LocalDate fecha) throws Exception;
}

