package com.mx.fonyou.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.fonyou.entity.ExamenEntity;

public interface ExamenRepository extends JpaRepository<ExamenEntity, Long> {
	
	ExamenEntity findById(int idExamen);
	
}
