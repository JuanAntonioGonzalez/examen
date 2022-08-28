package com.mx.fonyou.security.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mx.fonyou.entity.EstudianteEntity;
import com.mx.fonyou.entity.ExamenEntity;
import com.mx.fonyou.entity.PreguntasEntity;
import com.mx.fonyou.entity.ResultadoEntity;
import com.mx.fonyou.request.ResultadoRequest;
import com.mx.fonyou.security.JwtTokenUtil;
import com.mx.fonyou.security.JwtUser;
import com.mx.fonyou.security.repository.EstudianteRepository;
import com.mx.fonyou.security.repository.ExamenRepository;
import com.mx.fonyou.security.repository.PreguntasRepository;
import com.mx.fonyou.security.service.ExamenServiceImpl;

@RestController
public class UserRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @Autowired
    private EstudianteRepository estudianteRepository;
    
    @Autowired
    private PreguntasRepository preguntasRepository;

    @Autowired
    private ExamenRepository examenRepository;
    
    @Autowired
    private ExamenServiceImpl examenServiceImpl;
    
    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping(value = "user", method = RequestMethod.GET)
    public JwtUser getAuthenticatedUser(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
        return user;
    }
    
    @RequestMapping(value = "rest/listaEstudiantes", method = RequestMethod.GET)
    public List<EstudianteEntity> findAll() {
        return estudianteRepository.findAll();
    }
    
    @RequestMapping(value = "rest/listaPreguntas", method = RequestMethod.GET)
    public List<PreguntasEntity> listaPreguntas() {
        return preguntasRepository.findAll();
    }
    
    @RequestMapping(value = "rest/listaExamen", method = RequestMethod.GET)
    public List<ExamenEntity> findAllExamen() {
        return examenRepository.findAll();
    }
    
    @RequestMapping(value = "rest/resultadoExamen", method = RequestMethod.GET)
    public List<ExamenEntity> ResultadoExamenExamen() {
        return examenRepository.findAll();
    }
    
    
    @RequestMapping(value = "rest/respuestasExamen", method = RequestMethod.POST)
    public ResultadoEntity addEstudiante(@RequestBody ResultadoRequest respuestas) throws Exception {
    	
		return examenServiceImpl.addRespuestas(respuestas);
    }
    
    
}
