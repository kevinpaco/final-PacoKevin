package ar.edu.unju.fi.pvisual.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CURSO_ID")
	private Long id;
	
	@Column(name = "NOMBRE")
	private String nombre;
	
	@Column(name = "DESCRIPCION")
	private String descripcion;
	
	@Column(name = "CATEGORIA")
	private String categoria;
	
	@Column(name = "INSCRIPTOS")
	private int inscriptos;

	@Column(name = "FECHA_DE_PUBLICACION")
	private String fechaPublicasion;
	
	@Column(name = "DURACION")
	public String duracion;
	
	public Curso() {
		super();
	}

	


	public Curso(String nombre, String descripcion, String categoria, int inscriptos, String fechaPublicasion,
			String duracion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.inscriptos = inscriptos;
		this.fechaPublicasion = fechaPublicasion;
		this.duracion = duracion;
	}




	public Curso(Long id, String nombre, String descripcion, String categoria, int inscriptos, String fechaPublicasion,
			String duracion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.inscriptos = inscriptos;
		this.fechaPublicasion = fechaPublicasion;
		this.duracion = duracion;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getInscriptos() {
		return inscriptos;
	}

	public void setInscriptos(int inscriptos) {
		this.inscriptos = inscriptos;
	}




	public String getCategoria() {
		return categoria;
	}




	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}




	public String getFechaPublicasion() {
		return fechaPublicasion;
	}




	public void setFechaPublicasion(String fechaPublicasion) {
		this.fechaPublicasion = fechaPublicasion;
	}




	public String getDuracion() {
		return duracion;
	}




	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}




	@Override
	public String toString() {
		return ""+nombre;
	}	
	
	
}
