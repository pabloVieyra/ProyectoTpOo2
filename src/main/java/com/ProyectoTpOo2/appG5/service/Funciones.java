package com.ProyectoTpOo2.appG5.service;

import java.time.LocalDate;
import java.time.LocalTime;

public class Funciones {

	public static String traerFechaCorta(LocalDate fecha) {
		String fechaCorta;
		fechaCorta = "" + fecha.getDayOfMonth() + "-" + traducirMeses(fecha.getMonth().toString()) + "-"
				+ fecha.getYear();
		return fechaCorta;
	}

	public static String traducirMeses(String month) {
		String mes = "";

		switch (month) {
			case "JANUARY":
				mes = "Enero";
				break;
			case "FEBRUARY":
				mes = "Febrero";
				break;
			case "MARCH":
				mes = "Marzo";
				break;
			case "APRIL":
				mes = "Abril";
				break;
			case "MAY":
				mes = "Mayo";
				break;
			case "JUNE":
				mes = "Junio";
				break;
			case "JULY":
				mes = "Julio";
				break;
			case "AUGUST":
				mes = "Agosto";
				break;
			case "SEPTEMBER":
				mes = "Septiembre";
				break;
			case "OCTOBER":
				mes = "Octubre";
				break;
			case "NOVEMBER":
				mes = "Noviembre";
				break;
			case "DECEMBER":
				mes = "Diciembre";
				break;
			default:
				break;
		}

		return mes;
	}

	public static double convertirADouble(int n) {
		return ((double) n);
	}

	public static boolean esBisiesto(int anio) {
		return anio % 4 == 0 && (anio % 100 == 0 && anio % 400 == 0);
	}

	public static boolean esFechaValida(LocalDate fecha) {
		int anio = fecha.getYear();
		if (esBisiesto(anio)) {
			return true;
		} else {
			return false;
		}
	}

	public static String traerFechaLarga(LocalDate fecha) {
		String diaNom = fecha.getDayOfWeek().name();
		int diaNum = fecha.getDayOfWeek().getValue();
		String mes = fecha.getMonth().name();
		String anio = String.valueOf(fecha.getYear());
		return diaNom + " " + diaNum + " de " + mes + " de " + anio;
	}

	public static String traerHoraCorta(LocalTime hora) {
		String horas = String.valueOf(hora.getHour());
		String minutos = String.valueOf(hora.getMinute());

		return horas + ":" + minutos;

	}

	public static boolean esDiaHabil(LocalDate fecha) {
		int dia = fecha.getDayOfWeek().getValue();
		return ((dia >= 1) && (dia <= 5));
	}

	public static int traerDiaDeLaSemana(LocalDate fecha) {
		int dia = fecha.getDayOfWeek().getValue();
		return dia;
	}

	public static String traerMesEnLetras(LocalDate fecha) {
		String mes = fecha.getMonth().name();
		return mes;
	}

	
	//Lo uso
	public static int traerCantDiasDeUnMes(int anio, int mes) {
		LocalDate dias = LocalDate.of(anio, mes, 1);

		if (mes == 2) {
			if (esFechaValida(dias)) {
				return 29;
			} else {
				return dias.getDayOfMonth();
			}
		} else {
			return dias.getDayOfMonth();
		}
	}

	public static boolean esNumero(char c) {
		String codigo = Character.toString(c);
		int i = Integer.parseInt(codigo);
		if (i > -10 && i < 10) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean esLetra(char c) {
		String codigo = Character.toString(c);
		int i = Integer.parseInt(codigo);

		if ((i >= 65 && i <= 90) || (i >= 97 && i <= 122)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean esCadenaLetras(String cadena) {
		boolean check = true;
		if (cadena == null) {
			check = false;
		}

		int len = cadena.length();
		for (int i = 0; i < len; i++) {
			if ((Character.isLetter(cadena.charAt(i)) == false)) {
				check = false;
			}
		}

		return check;

	}

	public static boolean esCadenaNros(String cadena) {
		boolean check = true;
		if (cadena == null) {
			check = false;
		}

		int len = cadena.length();
		for (int i = 0; i < len; i++) {
			if (!(Character.isLetter(cadena.charAt(i)) == false)) {
				check = false;
			}
		}

		return check;

	}

	public static double aproximar2Decimal(double valor) {
		String chequear = String.valueOf(valor);
		if (Character.getNumericValue(chequear.charAt(4)) >= 5)
			chequear = chequear.substring(0, 3) + '1' + '0';
		else
			chequear = chequear.substring(0, 3) + '0' + '0';
		return Double.parseDouble(chequear);

	}

}
