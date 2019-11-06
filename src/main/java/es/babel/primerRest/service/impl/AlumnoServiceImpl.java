package es.babel.primerRest.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.babel.primerRest.dto.AlumnoVO;
import es.babel.primerRest.entities.AlumnoEntity;
import es.babel.primerRest.repository.AlumnoRepository;
import es.babel.primerRest.service.AlumnoService;
import es.babel.primerRest.service.converters.AlumnoConverter;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepo;
    
    @Autowired
    AlumnoConverter alumnoConv;

    @Override
    public AlumnoVO getAlumno(long id) {
    	return alumnoConv.alumnoEntityToAlumnoVo(alumnoRepo.findById(id).get());
    }

    @Override
    public List<AlumnoVO> getAllAlumnos() {
    	List<AlumnoEntity> listaEntity = alumnoRepo.findAll();
    	List<AlumnoVO> listaVO = new ArrayList<>();
    	for(AlumnoEntity alumno : listaEntity) {
    		listaVO.add(alumnoConv.alumnoEntityToAlumnoVo(alumno));
    	}
        return listaVO;
    }

    @Override
    public String createAlumno(AlumnoVO alumnoVO) {
    	String resultado;
    	try {
    		alumnoRepo.save(alumnoConv.alumnoVoToAlumnoEntity(alumnoVO));
    		resultado  = "OK";
    	}catch(Exception E) {
    		E.printStackTrace();
    	 	resultado = "KO";
    	}
        return resultado;
    }

    @Override
    public String updateAlumno(long id, AlumnoVO alumnoVO) {
    	String resultado;
    	try {
    		AlumnoEntity alumno = alumnoRepo.findById(id).get();
    		AlumnoEntity alumnoParse = alumnoConv.alumnoVoToAlumnoEntity(alumnoVO);
    		if(alumnoParse.getNombre() != null) {
    			alumno.setNombre(alumnoParse.getNombre());    			
    		}
    		if(alumnoParse.getFechaNacimiento() != null) {
    			alumno.setFechaNacimiento(alumnoParse.getFechaNacimiento());
    		}
    		if(alumnoParse.getApellidos() != null) {
    			alumno.setApellidos(alumnoParse.getApellidos());    			
    		}
    		alumnoRepo.save(alumno);
    		resultado  = "OK";
    	}catch(Exception E) {
    		E.printStackTrace();
    	 	resultado = "KO";
    	}
        return resultado;
    }

    @Override
    public String deleteAlumno(long id) {
    	String resultado;
    	try {
    		alumnoRepo.delete(alumnoRepo.findById(id).get());
    		resultado  = "OK";
    	}catch(Exception E) {
    		E.printStackTrace();
    	 	resultado = "KO";
    	}
        return resultado;
    }
}
