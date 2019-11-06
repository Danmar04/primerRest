package es.babel.primerRest.entities;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AlumnoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAlumno;
	
	@Column
	private String nombre;
	
	@Column
	private String apellidos;
	
	@Column
	private Date fechaNacimiento;

	public long getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(long idAlumno) {
		this.idAlumno = idAlumno;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(java.util.Date fechaNac) {
		this.fechaNacimiento = fechaNac;
	}
	
	
	
}
