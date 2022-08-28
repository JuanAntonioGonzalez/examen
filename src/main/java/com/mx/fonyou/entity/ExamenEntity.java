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
@Table(name = "examen")
@Getter
@Setter
public class ExamenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_examen")
    private int id;

    @Column(name = "nombre_examen", length = 100)
    @NotNull
    private String nombreExamen;
    

	public ExamenEntity(int id, String nombreExamen) {
		super();
		this.id = id;
		this.nombreExamen = nombreExamen;
	}

	public ExamenEntity() {
	}
    
    
}
