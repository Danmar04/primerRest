package es.babel.primerRest.service.converters;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import es.babel.primerRest.dto.AlumnoVO;
import es.babel.primerRest.entities.AlumnoEntity;

@Component
public class AlumnoConverter {

	public AlumnoVO alumnoEntityToAlumnoVo(AlumnoEntity alumno) {
		AlumnoVO resultado = new AlumnoVO();
		resultado.setId(alumno.getIdAlumno());
		resultado.setNombre(alumno.getNombre());
		resultado.setApellidos(alumno.getApellidos());
		Date fechaNac = alumno.getFechaNacimiento();
		resultado.setFechaNacimiento(fechaNac.toString());
		return resultado;
		
	}
	
	public AlumnoEntity alumnoVoToAlumnoEntity(AlumnoVO alumno) {
		AlumnoEntity resultado = new AlumnoEntity();
		if(alumno.getNombre() != null) {
			resultado.setNombre(alumno.getNombre());
		}
		if(alumno.getApellidos() != null) {
			resultado.setApellidos(alumno.getApellidos());
		}
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if(alumno.getFechaNacimiento() != null) {
				Date fechaNac;
				fechaNac = formatter.parse(alumno.getFechaNacimiento());
				resultado.setFechaNacimiento(fechaNac);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return resultado;
		
	}
}
