package ar.edu.unju.fi.pvisual.model;

import java.time.LocalDate; 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "curriculum")
public class Curriculum {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// CAMPO OBLIGATORIO
	
	@Column(name = "TELEFONO")
	@NotNull(message = "Debe ingresar un numero de telefono")
	private long telefono;

	@Column(name = "NOMBRE")
	@NotEmpty(message = "Debe ingresar su nombre")
	private String nombre;

	@Column(name = "APELLIDO")
	@NotEmpty(message = "Debe ingresar su apellido")
	private String apellido;

	@Column(name = "CARNET_CONDUCCION")
	private String carnetConducir;

	@Column(name = "FECHA_NACIMIENTO")
	@DateTimeFormat(iso = ISO.DATE)
	@Past
	@NotNull(message = "Debe ingresar una fecha de nacimiento")
	private LocalDate fecha_na;

	@Column(name = "EMAIL")
	@NotEmpty(message = "Debe ingresar su nombre")
	private String email;
	
	@Column(name = "DIRECCION")
	@NotEmpty(message = "Debe ingresar su Direccion")
	private String direccion;

	@Column(name = "PAIS")
	@NotEmpty(message = "Debe ingresar su pais")
	private String pais;
	
	//CAMPO OPCIONAL
	@Column(name = "CONOSIMIENTOS_INFORMATICA")
	private String conosimientosInfor;

	@Column(name = "IDIOMAS")
	private String idiomas;

	@Column(name = "INFORMACION")
	private String info;
	
	@Column(name = "perfil")
	private String perfil;

	// ESTUDIOS PRIMARIOS
	@Column(name = "institucion")
	private String institucion;
	
	@Column(name = "Primaria")
	private String primaria;
	
	@Column(name = "fhecha_inicio")
	@DateTimeFormat(iso = ISO.DATE)
	@Past
	private LocalDate fechaInicioP;
	
	@Column(name = "fecha_fin_primaria")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaFinP;
	
	//ESTUDIOS SECUNDARIOS
	
	@Column(name = "Secundario")
	private String secundario;
	
	@Column(name = "fecha_inicio_secundario")
	@DateTimeFormat(iso = ISO.DATE)
	@Past
	private LocalDate fechaInicioS;
	
	@Column(name = "Fecha_fin_secundario")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaFinS;
	
	@Column(name = "titulo_secundario")
	private String tituloS;
	
	//ESTUDIOS UNIVERSITARIOS
	
	@Column(name = "Universidad")
	private String universidad;
	
	@Column(name = "fecha_inicio_Univeridad")
	@DateTimeFormat(iso = ISO.DATE)
	@Past
	private LocalDate fechaInicioU;
	
	@Column(name = "Fecha_fin_Universidad")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate fechaFinU;
	
	@Column(name = "titulo_Universitario")
	private String tituloU;
	 
	// EXPERIENCIA LABORAL
	
	@Column(name = "empleador")
	private String empleador;

	@Column(name = "puesto_anterior")
	private String puesto;
	
	@Column(name = "fecha_inicio_experiencia")
	@DateTimeFormat(iso = ISO.DATE)
	@Past
	private LocalDate fechaInicioE;
	
	@Column(name = "fecha_fin_experiencia")
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate FechaFinE;
	
	@Column(name = "EXPERIENCIA_LABORAL")
	private String experiencialabo;
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Usuario_ID")
	private Usuario usuario;
	
	public Curriculum() {
		super();
	}

	public Curriculum(Long id, long telefono, String nombre, String apellido, String carnetConducir, LocalDate fecha_na,
			String email, String idiomas, String conosimientosInfor,
			String experiencialabo, String info, String direccion, String pais, Usuario usuario) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido = apellido;
		this.carnetConducir = carnetConducir;
		this.fecha_na = fecha_na;
		this.email = email;
		this.idiomas = idiomas;
		this.conosimientosInfor = conosimientosInfor;
		this.experiencialabo = experiencialabo;
		this.info = info;
		this.direccion = direccion;
		this.pais = pais;
		this.usuario = usuario;
	}

	public Curriculum(long telefono, String nombre, String apellido, String carnetConducir, LocalDate fecha_na,
			String email, String idiomas, String conosimientosInfor,
			String experiencialabo, String info, String direccion, String pais, Usuario usuario) {
		super();
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido = apellido;
		this.carnetConducir = carnetConducir;
		this.fecha_na = fecha_na;
		this.email = email;
		this.idiomas = idiomas;
		this.conosimientosInfor = conosimientosInfor;
		this.experiencialabo = experiencialabo;
		this.info = info;
		this.direccion = direccion;
		this.pais = pais;
		this.usuario = usuario;
	}

	
	
	

	public Curriculum(@NotNull(message = "Debe ingresar un numero de telefono") long telefono,
			@NotEmpty(message = "Debe ingresar su nombre") String nombre,
			@NotEmpty(message = "Debe ingresar su apellido") String apellido, String carnetConducir,
			@Past @NotNull(message = "Debe ingresar una fecha de nacimiento") LocalDate fecha_na,
			@NotEmpty(message = "Debe ingresar su nombre") String email,
			@NotEmpty(message = "Debe ingresar su Direccion") String direccion,
			@NotEmpty(message = "Debe ingresar su pais") String pais, String conosimientosInfor, String idiomas,
			String info, String perfil, String institucion, String primaria, @Past LocalDate fechaInicioP,
			LocalDate fechaFinP, String secundario, @Past LocalDate fechaInicioS, LocalDate fechaFinS, String tituloS,
			String universidad, @Past LocalDate fechaInicioU, LocalDate fechaFinU, String tituloU, String empleador,
			String puesto, @Past LocalDate fechaInicioE, LocalDate fechaFinE, String experiencialabo, Usuario usuario) {
		super();
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido = apellido;
		this.carnetConducir = carnetConducir;
		this.fecha_na = fecha_na;
		this.email = email;
		this.direccion = direccion;
		this.pais = pais;
		this.conosimientosInfor = conosimientosInfor;
		this.idiomas = idiomas;
		this.info = info;
		this.perfil = perfil;
		this.institucion = institucion;
		this.primaria = primaria;
		this.fechaInicioP = fechaInicioP;
		this.fechaFinP = fechaFinP;
		this.secundario = secundario;
		this.fechaInicioS = fechaInicioS;
		this.fechaFinS = fechaFinS;
		this.tituloS = tituloS;
		this.universidad = universidad;
		this.fechaInicioU = fechaInicioU;
		this.fechaFinU = fechaFinU;
		this.tituloU = tituloU;
		this.empleador = empleador;
		this.puesto = puesto;
		this.fechaInicioE = fechaInicioE;
		FechaFinE = fechaFinE;
		this.experiencialabo = experiencialabo;
		this.usuario = usuario;
	}

	
	
	public Curriculum(Long id, @NotNull(message = "Debe ingresar un numero de telefono") long telefono,
			@NotEmpty(message = "Debe ingresar su nombre") String nombre,
			@NotEmpty(message = "Debe ingresar su apellido") String apellido, String carnetConducir,
			@Past @NotNull(message = "Debe ingresar una fecha de nacimiento") LocalDate fecha_na,
			@NotEmpty(message = "Debe ingresar su nombre") String email,
			@NotEmpty(message = "Debe ingresar su Direccion") String direccion,
			@NotEmpty(message = "Debe ingresar su pais") String pais, String conosimientosInfor, String idiomas,
			String info, String perfil, String institucion, String primaria, @Past LocalDate fechaInicioP,
			LocalDate fechaFinP, String secundario, @Past LocalDate fechaInicioS, LocalDate fechaFinS, String tituloS,
			String universidad, @Past LocalDate fechaInicioU, LocalDate fechaFinU, String tituloU, String empleador,
			String puesto, @Past LocalDate fechaInicioE, LocalDate fechaFinE, String experiencialabo, Usuario usuario) {
		super();
		this.id = id;
		this.telefono = telefono;
		this.nombre = nombre;
		this.apellido = apellido;
		this.carnetConducir = carnetConducir;
		this.fecha_na = fecha_na;
		this.email = email;
		this.direccion = direccion;
		this.pais = pais;
		this.conosimientosInfor = conosimientosInfor;
		this.idiomas = idiomas;
		this.info = info;
		this.perfil = perfil;
		this.institucion = institucion;
		this.primaria = primaria;
		this.fechaInicioP = fechaInicioP;
		this.fechaFinP = fechaFinP;
		this.secundario = secundario;
		this.fechaInicioS = fechaInicioS;
		this.fechaFinS = fechaFinS;
		this.tituloS = tituloS;
		this.universidad = universidad;
		this.fechaInicioU = fechaInicioU;
		this.fechaFinU = fechaFinU;
		this.tituloU = tituloU;
		this.empleador = empleador;
		this.puesto = puesto;
		this.fechaInicioE = fechaInicioE;
		FechaFinE = fechaFinE;
		this.experiencialabo = experiencialabo;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCarnetConducir() {
		return carnetConducir;
	}

	public void setCarnetConducir(String carnetConducir) {
		this.carnetConducir = carnetConducir;
	}

	public LocalDate getFecha_na() {
		return fecha_na;
	}

	public void setFecha_na(LocalDate fecha_na) {
		this.fecha_na = fecha_na;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(String idiomas) {
		this.idiomas = idiomas;
	}

	public String getConosimientosInfor() {
		return conosimientosInfor;
	}

	public void setConosimientosInfor(String conosimientosInfor) {
		this.conosimientosInfor = conosimientosInfor;
	}

	public String getExperiencialabo() {
		return experiencialabo;
	}

	public void setExperiencialabo(String experiencialabo) {
		this.experiencialabo = experiencialabo;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getPrimaria() {
		return primaria;
	}

	public void setPrimaria(String primaria) {
		this.primaria = primaria;
	}

	public LocalDate getFechaInicioP() {
		return fechaInicioP;
	}

	public void setFechaInicioP(LocalDate fechaInicioP) {
		this.fechaInicioP = fechaInicioP;
	}

	public LocalDate getFechaFinP() {
		return fechaFinP;
	}

	public void setFechaFinP(LocalDate fechaFinP) {
		this.fechaFinP = fechaFinP;
	}

	public String getSecundario() {
		return secundario;
	}

	public void setSecundario(String secundario) {
		this.secundario = secundario;
	}

	public LocalDate getFechaInicioS() {
		return fechaInicioS;
	}

	public void setFechaInicioS(LocalDate fechaInicioS) {
		this.fechaInicioS = fechaInicioS;
	}

	public LocalDate getFechaFinS() {
		return fechaFinS;
	}

	public void setFechaFinS(LocalDate fechaFinS) {
		this.fechaFinS = fechaFinS;
	}

	public String getEmpleador() {
		return empleador;
	}

	public void setEmpleador(String empleador) {
		this.empleador = empleador;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public LocalDate getFechaInicioE() {
		return fechaInicioE;
	}

	public void setFechaInicioE(LocalDate fechaInicioE) {
		this.fechaInicioE = fechaInicioE;
	}

	public LocalDate getFechaFinE() {
		return FechaFinE;
	}

	public void setFechaFinE(LocalDate fechaFinE) {
		FechaFinE = fechaFinE;
	}

	public String getTituloS() {
		return tituloS;
	}

	public void setTituloS(String tituloS) {
		this.tituloS = tituloS;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}

	public LocalDate getFechaInicioU() {
		return fechaInicioU;
	}

	public void setFechaInicioU(LocalDate fechaInicioU) {
		this.fechaInicioU = fechaInicioU;
	}

	public LocalDate getFechaFinU() {
		return fechaFinU;
	}

	public void setFechaFinU(LocalDate fechaFinU) {
		this.fechaFinU = fechaFinU;
	}

	public String getTituloU() {
		return tituloU;
	}

	public void setTituloU(String tituloU) {
		this.tituloU = tituloU;
	}

	@Override
	public String toString() {
		return "Curriculum [id=" + id + ", telefono=" + telefono + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", carnetConducir=" + carnetConducir + ", fecha_na=" + fecha_na + ", email=" + email + ", direccion="
				+ direccion + ", pais=" + pais + ", conosimientosInfor=" + conosimientosInfor + ", idiomas=" + idiomas
				+ ", info=" + info + ", perfil=" + perfil + ", institucion=" + institucion + ", primaria=" + primaria
				+ ", fechaInicioP=" + fechaInicioP + ", fechaFinP=" + fechaFinP + ", secundario=" + secundario
				+ ", fechaInicioS=" + fechaInicioS + ", fechaFinS=" + fechaFinS + ", tituloS=" + tituloS
				+ ", universidad=" + universidad + ", fechaInicioU=" + fechaInicioU + ", fechaFinU=" + fechaFinU
				+ ", tituloU=" + tituloU + ", empleador=" + empleador + ", puesto=" + puesto + ", fechaInicioE="
				+ fechaInicioE + ", FechaFinE=" + FechaFinE + ", experiencialabo=" + experiencialabo + ", usuario="
				+ usuario + "]";
	}

	
	

}
