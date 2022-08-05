package ar.edu.unju.fi.pvisual.model;

import java.io.Serializable; 
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Component
@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long id;
	  
	  @Column(name = "DNI")
	  @NotNull(message = "Debe ingresar su DNI")
	  @Min(value = 10000000, message="El dni debe tener minimo 8 dijitos")
	  private Long dni;
	  
	 @Column(name = "EMAIL")
	 @NotEmpty(message = "Debe ingresar un Mail")
	 @Email
	 private String email;
	 
	 @Column(name = "ESTADO_CIVIL")
	 @NotEmpty(message = "Debe ingresar el estado Civil")
	 private String estadoCivil;
	 
	 @Column(name = "PROVINCIA")
	 @NotEmpty(message = "Debe ingresar la Provincia" )
	 private String provincia;
	 
	 @Column(name = "TELEFONO")
	 //@Size(min=10, message = "El numero de tener minimo 10 dijitos" )
	 @NotNull(message ="Debe ingresar su Telefono")
	 private Long telefono;
	 
	 @Column(name = "FECHA_DE_NACIMIENTO")
     @NotNull
	 @DateTimeFormat(iso = ISO.DATE)
	 @Past
	 @NotNull(message = "Debe ingresar una fecha de Nacimiento")
	 private LocalDate fechaNacimiento;
	 
	 private String tipo;
	 
	@Column(name = "CONTRASEÑA")
	@NotEmpty(message = "Debe ingresar la Contraseña" )
	 private String contraseña;
	
	private String nombre;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL )
	private List<Curriculum> curriculum = new ArrayList<Curriculum>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JsonBackReference
	@JoinTable(name = "USUARIO_CURSO",
	joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "CURSO_ID", referencedColumnName = "CURSO_ID"))
	private Set<Curso> curso = new HashSet<>(); 
	
	public void añadirCurso(Curso curso) {
		this.curso.add(curso);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Curriculum> getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(List<Curriculum> curriculum) {
		this.curriculum = curriculum;
	}
	public Usuario() {
		super();
	}
	public Usuario(Long dni,String email, String estadoCivil, String provincia, Long telefono,
			LocalDate fechaNacimiento, String contraseña) {
		super();
		this.dni = dni;
		this.email = email;
		this.estadoCivil = estadoCivil;
		this.provincia = provincia;
		this.telefono = telefono;
		this.fechaNacimiento = fechaNacimiento;
		this.contraseña = contraseña;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public Set<Curso> getCurso() {
		return curso;
	}
	public void setCurso(Set<Curso> curso) {
		this.curso = curso;
	}

	
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", dni=" + dni + ", email=" + email + ", estadoCivil=" + estadoCivil
				+ ", provincia=" + provincia + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento
				+ ", contraseña=" + contraseña + ", curriculum=" + curriculum + ", curso=" + curso + "]";
	}
	 
	
	 
}
