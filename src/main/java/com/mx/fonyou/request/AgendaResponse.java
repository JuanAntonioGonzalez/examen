package com.mx.fonyou.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendaResponse {

	private String estudiante;
	private String examen;
	private String fecha;
	public AgendaResponse(String estudiante, String examen, String fecha) {
		super();
		this.estudiante = estudiante;
		this.examen = examen;
		this.fecha = fecha;
	}
	public AgendaResponse() {
	}
	
}
