package es.babel.primerRest.repository;

import es.babel.primerRest.dto.AlumnoVO;

import java.util.List;

public interface AlumnoRepository {

    public AlumnoVO getAlumno(long id);

    public List<AlumnoVO> getAll();

    public String createAlumno(AlumnoVO alumnoVO);

    public String updateAlumno(long id, AlumnoVO alumnoVO);

    public String deleteAlumno(long id);
}
