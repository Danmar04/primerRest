package es.babel.primerRest.service;

import es.babel.primerRest.dto.AlumnoVO;

import java.util.List;

public interface AlumnoService {
    public AlumnoVO getAlumno( long id);
    public List<AlumnoVO> getAllAlumnos();
    public String createAlumno(AlumnoVO alumnoVO);
    public String updateAlumno(long id, AlumnoVO alumnoVO);
    public String deleteAlumno(long id);
}
