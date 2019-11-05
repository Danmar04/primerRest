package es.babel.primerRest.service.impl;

import es.babel.primerRest.dto.AlumnoVO;
import es.babel.primerRest.repository.AlumnoRepository;
import es.babel.primerRest.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoServiceImpl implements AlumnoService {

    @Autowired
    AlumnoRepository alumnoRepo;

    @Override
    public AlumnoVO getAlumno(long id) {
        return alumnoRepo.getAlumno(id);
    }

    @Override
    public List<AlumnoVO> getAllAlumnos() {
        return alumnoRepo.getAll();
    }

    @Override
    public String createAlumno(AlumnoVO alumnoVO) {
        return alumnoRepo.createAlumno(alumnoVO);
    }

    @Override
    public String updateAlumno(long id, AlumnoVO alumnoVO) {
        return alumnoRepo.updateAlumno(id, alumnoVO);
    }

    @Override
    public String deleteAlumno(long id) {
        return alumnoRepo.deleteAlumno(id);
    }
}
