package com.mx.fonyou.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estudiante_examen")
@Getter
@Setter
public class EstudianteExamenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudiante_examen")
    private Long idExamen;
	
	@Column(name = "respuesta_estudiante_uno", length = 1)
    @NotNull
    private int respuestaEstudianteUno;
	
	@Column(name = "respuesta_estudiante_dos", length = 1)
    @NotNull
    private int respuestaEstudianteDos;
	
	@Column(name = "respuesta_estudiante_tres", length = 1)
    @NotNull
    private int respuestaEstudianteTres;
	
	@Column(name = "respuesta_estudiante_cuatro", length = 1)
    @NotNull
    private int respuestaEstudianteCuatro;
	
	@ManyToOne
    @MapsId("id_estudiante")
    @JoinColumn(name = "id_estudiante")
    EstudianteEntity estudiante;

    @ManyToOne
    @MapsId("id_examen")
    @JoinColumn(name = "id_examen")
    ExamenEntity course;
    
    @Transient
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int idEstudiante;

	public EstudianteExamenEntity() {
	}

	public EstudianteExamenEntity(Long idExamen, int respuestaEstudianteUno, int respuestaEstudianteDos,
			int respuestaEstudianteTres, int respuestaEstudianteCuatro, EstudianteEntity estudiante,
			ExamenEntity course, int idEstudiante) {
		super();
		this.idExamen = idExamen;
		this.respuestaEstudianteUno = respuestaEstudianteUno;
		this.respuestaEstudianteDos = respuestaEstudianteDos;
		this.respuestaEstudianteTres = respuestaEstudianteTres;
		this.respuestaEstudianteCuatro = respuestaEstudianteCuatro;
		this.estudiante = estudiante;
		this.course = course;
		this.idEstudiante = idEstudiante;
	}
    
    
}
