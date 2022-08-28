package com.mx.fonyou.security.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mx.fonyou.entity.EstudianteEntity;
import com.mx.fonyou.entity.ExamenEntity;
import com.mx.fonyou.entity.LocacionEntity;
import com.mx.fonyou.entity.PreguntasEntity;
import com.mx.fonyou.entity.ResultadoEntity;
import com.mx.fonyou.request.ResultadoRequest;
import com.mx.fonyou.security.repository.EstudianteRepository;
import com.mx.fonyou.security.repository.ExamenRepository;
import com.mx.fonyou.security.repository.LocacionRepository;
import com.mx.fonyou.security.repository.PreguntasRepository;
import com.mx.fonyou.security.repository.ResultadoRepository;
import com.mx.fonyou.utils.ConstantsEnum;


@Service
public class ExamenServiceImpl {
	
    @Autowired
    private LocacionRepository locacionRepository;
    
    @Autowired
    private EstudianteRepository estudianteRepository;
    
    @Autowired
    private PreguntasRepository preguntasRepository;
    
    @Autowired
    private ResultadoRepository resultadoRepository;
    
    @Autowired
    private ExamenRepository examenRepository;

    public EstudianteEntity addEstudiante(EstudianteEntity estudiante) throws Exception {
    	
    	LocacionEntity location = locacionRepository.findById(estudiante.getLocacion());
    	
    	if(location == null) {
    		throw new Exception(String.format(ConstantsEnum.NO_EXISTE_LOCACION, estudiante.getLocacion()));
    	}    
		estudiante.setId_locacion(location);
		return estudianteRepository.save(estudiante);

    }

	public ResultadoEntity addRespuestas(ResultadoRequest respuestas) throws Exception{
		
		AtomicInteger count = new AtomicInteger();
		ResultadoEntity resultado = new  ResultadoEntity();
		ExamenEntity examenId = examenRepository.findById(respuestas.getIdExamen());
		if(examenId == null)
			throw new Exception(String.format(ConstantsEnum.PROBLEMA_CONSAULTAR_EXAMEN, respuestas.getIdExamen()));
		List<PreguntasEntity> examen = preguntasRepository.findByIdExamen(examenId);
		if(examen == null)
			throw new Exception(String.format(ConstantsEnum.SIN_RESPUESTAS, respuestas.getIdExamen()));
		
		try {
			examen.stream().forEach((p)-> {
				System.out.println("<<>> Las preguntas filtradas son " + p.getIdExamen().getId() + "  --  " + p.getQuestion()); 
				respuestas.getRespuestas().stream().forEach((preg) ->{
					if(preg.getIdPregunta() == p.getIdPregunta()) {
						if(preg.getRespuestaEstudiante() == p.getRespuestaCorrecta()) {						
							count.incrementAndGet();
						}					
					}
				});
			});
			float calificacion = (float)(count.get() * 100 ) / examen.size();
			
			SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm zzz");
	        Calendar calendar = Calendar.getInstance();
	        Date dateObj = calendar.getTime();
	        String formattedDate = dtf.format(dateObj);
			resultado.setFecha(formattedDate);
			resultado.setIdEstudiante(respuestas.getIdEstudiante());
			resultado.setIdExamen(respuestas.getIdExamen());
			resultado.setResultadoExamen(String.valueOf(calificacion) + "%");
		}catch (Exception e) {
			throw new Exception(ConstantsEnum.SIN_RESPUESTAS);
		}		
		
		return resultadoRepository.save(resultado);
	}
	
}
