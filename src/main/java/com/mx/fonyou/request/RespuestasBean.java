package com.mx.fonyou.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespuestasBean {

	private int idPregunta;
	private int respuestaEstudiante;
	public RespuestasBean(int idPregunta, int respuestaEstudiante) {
		super();
		this.idPregunta = idPregunta;
		this.respuestaEstudiante = respuestaEstudiante;
	}
	public RespuestasBean() {
	}
}
