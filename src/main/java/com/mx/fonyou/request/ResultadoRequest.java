package com.mx.fonyou.request;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultadoRequest {
	
	private int idEstudiante;
	private int idExamen;
	private List<RespuestasBean> respuestas;
	public ResultadoRequest(int idEstudiante, int idExamen, List<RespuestasBean> respuestas) {
		super();
		this.idEstudiante = idEstudiante;
		this.idExamen = idExamen;
		this.respuestas = respuestas;
	}
	public ResultadoRequest() {
	}

	
}
