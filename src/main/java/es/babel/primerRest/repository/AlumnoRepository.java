package es.babel.primerRest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.babel.primerRest.entities.AlumnoEntity;

public interface AlumnoRepository extends JpaRepository<AlumnoEntity, Long>{

}
