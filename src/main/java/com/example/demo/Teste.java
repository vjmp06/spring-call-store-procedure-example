package com.example.demo;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class Teste {
	
	public static void main(String[] args) {
		System.out.println(quintaAnteriorASextaDoMesSeguinte());
	}
	
	public static LocalDate primeiraSextaDoMes() {
		LocalDate dtInicio = LocalDate.now();
		dtInicio = dtInicio.minusDays(dtInicio.getDayOfMonth());
		dtInicio = dtInicio.plusDays(1);
		if(dtInicio.getDayOfWeek() != DayOfWeek.FRIDAY) {
			dtInicio = dtInicio.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
		}
		
		return dtInicio;
		
	}
	
	public static LocalDate quintaAnteriorASextaDoMesSeguinte() {
		LocalDate dtInicio = LocalDate.now();
		LocalDate dtFinal = dtInicio.plusMonths(1);
		dtFinal = dtFinal.minusDays(dtInicio.getDayOfMonth());
		dtFinal = dtFinal.plusDays(1);
		if(dtFinal.getDayOfWeek() != DayOfWeek.FRIDAY) {
			dtFinal = dtFinal.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
			dtFinal = dtFinal.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
			
		}
		else {
			dtFinal = dtFinal.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY));
		}
		
		return dtFinal;
		
	}

}
