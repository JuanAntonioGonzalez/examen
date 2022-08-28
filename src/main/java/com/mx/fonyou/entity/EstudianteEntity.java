package com.mx.fonyou.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "estudiante")
@Getter
@Setter
public class EstudianteEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_estudante")
    private Long id;

    @Column(name = "nombre", length = 100)
    @NotNull
    private String nombreEstudiante;
    
    @Column(name = "edad", length = 2)
    @NotNull
    private int edadEstudiante;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_locacion", referencedColumnName = "id_locacion")
    @NotNull
    private LocacionEntity id_locacion;
    
    @Transient
    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    private int locacion;

	public EstudianteEntity() {
		
	}

	public EstudianteEntity(Long id, String nombreEstudiante, int edadEstudiante, LocacionEntity id_locacion, int locacion) {
		super();
		this.id = id;
		this.nombreEstudiante = nombreEstudiante;
		this.edadEstudiante = edadEstudiante;
		this.id_locacion = id_locacion;
		this.locacion = locacion;
	}     

}
