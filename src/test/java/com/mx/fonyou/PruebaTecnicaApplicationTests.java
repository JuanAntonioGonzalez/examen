package com.mx.fonyou;

import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mx.fonyou.entity.EstudianteEntity;
import com.mx.fonyou.entity.ExamenEntity;
import com.mx.fonyou.entity.LocacionEntity;
import com.mx.fonyou.entity.PreguntasEntity;
import com.mx.fonyou.entity.ResultadoEntity;
import com.mx.fonyou.security.repository.EstudianteRepository;
import com.mx.fonyou.security.repository.ExamenRepository;
import com.mx.fonyou.security.repository.PreguntasRepository;
import com.mx.fonyou.security.repository.ResultadoRepository;
import com.mx.fonyou.utils.ConstantsEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PruebaTecnicaApplicationTests {
	
	@Autowired
    private EstudianteRepository estudianteRepository;
	
	@Autowired
    private ExamenRepository examenRepository;
	
	@Autowired
    private PreguntasRepository preguntasRepository;
	
	@Autowired
    private ResultadoRepository resultadoRepository;



	@Before
	public void agregaDatos() {
		ExamenEntity examenEntity = new ExamenEntity();
		examenEntity.setNombreExamen("Java Senior");
		examenRepository.save(examenEntity);
	}
	
	@Test
	public void agregaEstudiante() {
		EstudianteEntity estudiante = new EstudianteEntity();
		estudiante.setEdadEstudiante(30);
		LocacionEntity locacionEntity = new LocacionEntity();
		locacionEntity.setCity("Puebla");
		locacionEntity.setZona("CTS");
		estudiante.setId_locacion(locacionEntity);
		estudiante.setNombreEstudiante("Pedro Paramo");
		
		EstudianteEntity estudianteRegistrado = estudianteRepository.save(estudiante);
		assertNotNull(estudianteRegistrado);
	}
	
	@Test
	public void agregaExamen() {
		
		ExamenEntity examenEntity = new ExamenEntity();
		examenEntity.setNombreExamen("Java Senior");
		
		ExamenEntity examenRegistrado = examenRepository.save(examenEntity);
		assertNotNull(examenRegistrado);
	}
	
	@Test
	public void contestaExamen() {
		
		ResultadoEntity resultado = new  ResultadoEntity();
		ExamenEntity examenId = examenRepository.findById(1);		
		List<PreguntasEntity> examen = preguntasRepository.findByIdExamen(examenId);		
		
		float calificacion = (float)(2 * 100 ) / examen.size();
		
		SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm zzz");
        Calendar calendar = Calendar.getInstance();
        Date dateObj = calendar.getTime();
        String formattedDate = dtf.format(dateObj);
		resultado.setFecha(formattedDate);
		resultado.setIdEstudiante(1);
		resultado.setIdExamen(1);
		resultado.setResultadoExamen(String.valueOf(calificacion) + "%");
	
		ResultadoEntity registrado = resultadoRepository.save(resultado);
		assertNotNull(registrado);
	}

}
