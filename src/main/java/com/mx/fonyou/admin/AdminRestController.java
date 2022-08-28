package com.mx.fonyou.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mx.fonyou.entity.EstudianteEntity;
import com.mx.fonyou.entity.ResultadoEntity;
import com.mx.fonyou.security.repository.ResultadoRepository;
import com.mx.fonyou.security.service.ExamenServiceImpl;


@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminRestController {
	
	@Autowired
    private ResultadoRepository resultadoRepository;
	
	@Autowired
    private ExamenServiceImpl examenServiceImpl;


    @RequestMapping(method = RequestMethod.GET)
    public String find() {
        return "This resource is protected";
    }
    
    @RequestMapping(value = "calificacion", method = RequestMethod.GET)
    public List<ResultadoEntity> getCalificacion(@RequestParam(name="estudianteId") int idEstudiante) throws Exception {
    	
    	System.out.println("estudianteId  " + idEstudiante);
		return resultadoRepository.findByIdEstudiante(idEstudiante);
    }
    
    @RequestMapping(value = "agregaEstudiante", method = RequestMethod.POST)
    public EstudianteEntity addEstudiante(@RequestBody EstudianteEntity estudiante) throws Exception {
    	
		return examenServiceImpl.addEstudiante(estudiante);
    }
    
}

