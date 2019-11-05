package es.babel.primerRest.repository.impl;

import es.babel.primerRest.dto.AlumnoVO;
import es.babel.primerRest.repository.AlumnoRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AlumnosRepositoryImpl implements AlumnoRepository {

    private List<AlumnoVO> listaAlumnos = new ArrayList<>();
    private int numAlums = 0;

    public int getNumAlums() {
        return this.numAlums;
    }
    public void setNumAlums(int nuevoNum) {
        this.numAlums = nuevoNum;
    }
    public List<AlumnoVO> getLista(){
        return this.listaAlumnos;
    }

    public void setLista(List nuevaLista){
        this.listaAlumnos = nuevaLista;
    }

    @Override
    public AlumnoVO getAlumno(long id) {
        List<AlumnoVO> lista = this.getLista();
        for(AlumnoVO alumno : listaAlumnos) {
            if(alumno.getId() == id)
                return alumno;
        }
        return null;
    }

    @Override
    public List<AlumnoVO> getAll() {
        return this.getLista();
    }

    @Override
    public String createAlumno(AlumnoVO alumnoVO) {
        List<AlumnoVO> lista = this.getLista();
        int nuevoTam = this.getNumAlums() + 1;
        alumnoVO.setId(nuevoTam);
        this.setNumAlums(nuevoTam);
        lista.add(alumnoVO);
        try {
            this.setLista(lista);
        }
        catch (Exception e) {
            return "KO";
        }
        return "Ok";
    }

    @Override
    public String updateAlumno(long id, AlumnoVO alumnoVO) {
        List<AlumnoVO> lista = this.getLista();
        for(AlumnoVO alumno : listaAlumnos) {
            if(alumno.getId() == id) {
                alumno.setApellidos(alumnoVO.getApellidos());
                alumno.setNombre(alumnoVO.getNombre());
                alumno.setFechaNacimiento(alumnoVO.getFechaNacimiento());
                return "OK";
            }
        }
        return "KO";
    }

    @Override
    public String deleteAlumno(long id) {
        List<AlumnoVO> lista = new ArrayList<>();
        for(AlumnoVO alumno : this.getLista()) {
            if(alumno.getId() != id)
               lista.add(alumno);
        }
        this.setLista(lista);
        return "OK";
    }
}
