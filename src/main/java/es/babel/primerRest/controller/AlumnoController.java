package es.babel.primerRest.controller;

import es.babel.primerRest.dto.AlumnoVO;
import es.babel.primerRest.service.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import javax.xml.ws.Response;
import java.util.List;

@RestController
public class AlumnoController {
    @Autowired
    AlumnoService alumnoService;

    @GetMapping("/alumno/{id}")
    public ResponseEntity<AlumnoVO> getAlumnoById(@PathVariable (name="id") long id){
        System.out.println("Entro en GET");
        return ResponseEntity.ok(alumnoService.getAlumno(id));
    };
    @GetMapping("/alumno/list")
    public List<AlumnoVO> getAllAlumno(){
        return alumnoService.getAllAlumnos();
    };
    @PostMapping("/alumno")
    public ResponseEntity<String> createAlumno(@RequestBody AlumnoVO alumnoVO){
        return ResponseEntity.ok(alumnoService.createAlumno(alumnoVO));
    };
    @PutMapping("/alumno/{id}")
    public ResponseEntity<String> updateAlumno(@PathVariable (name="id") long id, @RequestBody AlumnoVO alumnoVO){
        return ResponseEntity.ok(alumnoService.updateAlumno(id, alumnoVO ));
    };
    @DeleteMapping("/alumno/{id}")
    public ResponseEntity<String> deleteAlumno(@PathVariable (name="id") long id){
        return ResponseEntity.ok(alumnoService.deleteAlumno(id));
    };

}
