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
@Table(name = "agendaExamen")
@Getter
@Setter
public class AgendaExamenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agenda")
    private Long id;

    @Column(name = "id_estudiante", length = 2)
    @NotNull
    private int estudiante;
    
    @Column(name = "id_examen", length = 2)
    @NotNull
    private int examen;
    
    @Column(name = "fecha_examen", length = 20)
    @NotNull
    private String fechaEamen;

	public AgendaExamenEntity(Long id, int estudiante, int examen, String fechaEamen) {
		super();
		this.id = id;
		this.estudiante = estudiante;
		this.examen = examen;
		this.fechaEamen = fechaEamen;
	}

	public AgendaExamenEntity() {
		
	}
    
}
