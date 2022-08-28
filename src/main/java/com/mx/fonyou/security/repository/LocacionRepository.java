package com.mx.fonyou.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.fonyou.entity.LocacionEntity;

public interface LocacionRepository extends JpaRepository<LocacionEntity, Long> {
	
	LocacionEntity findById(int id);
}
