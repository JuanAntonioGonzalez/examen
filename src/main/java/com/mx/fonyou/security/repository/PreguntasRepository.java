package com.mx.fonyou.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.fonyou.entity.ExamenEntity;
import com.mx.fonyou.entity.PreguntasEntity;

public interface PreguntasRepository extends JpaRepository<PreguntasEntity, Long> {

	List<PreguntasEntity> findByIdExamen(ExamenEntity id);

}
