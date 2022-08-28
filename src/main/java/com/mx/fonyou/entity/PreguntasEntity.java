package com.mx.fonyou.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "preguntas")
@Getter
@Setter
public class PreguntasEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_preguntas")
    private Long idPregunta;

    @Column(name = "pregunta", length = 250)
    @NotNull
    private String question;
    
    @Column(name = "respuesta_uno", length = 250)
    @NotNull
    private String respuestaUno;
    
    @Column(name = "respuesta_dos", length = 250)
    @NotNull
    private String respuestaDos;
    
    @Column(name = "respuesta_tres", length = 250)
    @NotNull
    private String respuestaTres;
    
    @Column(name = "respuesta_cuatro", length = 250)
    @NotNull
    private String respuestaCuatro;
    
    @Column(name = "respuesta_correcta", length = 1)
    @NotNull
    private int respuestaCorrecta;
    
 
    @ManyToOne
    @JoinColumn(name="id_examen", nullable=false)
    private ExamenEntity idExamen;


	public PreguntasEntity() {
	}

	public PreguntasEntity(Long idPregunta, String question, String respuestaUno, String respuestaDos, String respuestaTres,
			String respuestaCuatro, int respuestaCorrecta, ExamenEntity idExamen) {
		super();
		this.idPregunta = idPregunta;
		this.question = question;
		this.respuestaUno = respuestaUno;
		this.respuestaDos = respuestaDos;
		this.respuestaTres = respuestaTres;
		this.respuestaCuatro = respuestaCuatro;
		this.respuestaCorrecta = respuestaCorrecta;
		this.idExamen = idExamen;
	}
    
    
    
    
}
