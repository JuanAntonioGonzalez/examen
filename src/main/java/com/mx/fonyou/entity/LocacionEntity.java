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
@Table(name = "locacion")
@Getter
@Setter
public class LocacionEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_locacion")
    private int id;

    @Column(name = "ciudad", length = 100)
    @NotNull
    private String city;
    
    @Column(name = "zona_horaria", length = 25)
    @NotNull
    private String zona;

}
