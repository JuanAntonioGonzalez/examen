package com.mx.fonyou.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.fonyou.entity.ResultadoEntity;

public interface ResultadoRepository extends JpaRepository<ResultadoEntity, Long> {
    
	List<ResultadoEntity> findByIdEstudiante(int id);
}
