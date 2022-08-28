package com.mx.fonyou.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.fonyou.entity.EstudianteEntity;

public interface EstudianteRepository extends JpaRepository<EstudianteEntity, Long> {
    //User findByUsername(String username);
}
