package com.mx.fonyou.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "resultado")
@Getter
@Setter
public class ResultadoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_resultados")
    private int id;

    @Column(name = "id_examen", length = 2)
    @NotNull
    private int idExamen;
    
    @Column(name = "id_estudiante", length = 2)
    @NotNull
    private int idEstudiante;
    
    @Column(name = "fecha", length = 25)
    @NotNull
    private String fecha;
    
    @Column(name = "resultado", length = 8)
    @NotNull
    private String resultadoExamen;

	public ResultadoEntity(int id, int idExamen, int idEstudiante, String fecha, String resultadoExamen) {
		super();
		this.id = id;
		this.idExamen = idExamen;
		this.idEstudiante = idEstudiante;
		this.fecha = fecha;
		this.resultadoExamen = resultadoExamen;
	}
    
	public ResultadoEntity() {
		
	}
}
