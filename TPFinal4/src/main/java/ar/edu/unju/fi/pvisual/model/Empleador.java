package ar.edu.unju.fi.pvisual.model;

import java.io.Serializable; 
import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "empleadores")
public class Empleador implements Serializable {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "CUIT")
	 private Long cuit;
    
    @Column(name = "CONTRASEÑA")
    @NotEmpty(message = "Debe ingresar Una Contraseña")
	 private String contrasena;
    
    @Column(name = "RAZON_SOCIAL")
    @NotBlank(message = "Debe ingresar una Razon Social")
	 private String razonSocial;
    
    @Column(name = "NOMBRE_COMERCIAL")
   @NotEmpty(message = "Debe ingresar un nombre Comercial")
	 private String nombreComercial;
    
    @Column(name = "INICIO_ACTIVIDAD")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inicioActividad;
	
    @Column(name = "EMAIL")
    @NotEmpty(message = "Debe ingresar un Email")
    //@Email
    private String email;
    
    @Column(name = "TELEFONO")
    
	 private Long telefono;
    
    @Column(name = "DOMICILIO")
    @NotEmpty(message = "Debe ingresar un Domicilio")
	private String domicilio;
    
    @Column(name = "PROVINCIA")
    //@NotEmpty(message  = "Debe ingresar una Provincia")
	private String provincia;
    
    @Column(name = "PAGINA_WEB")
    @NotEmpty(message = "Debe ingresar una Pagina Web")
	private String paginaWeb;
    
    private String tipo;
    
    @Column(name = "DESCRIPCION")
    @NotEmpty(message="Debe ingresar una Descripsion")
	private String descripcion;
    
    @OneToMany(mappedBy = "empleador2", cascade = CascadeType.ALL)
   private List<OfertaLaboral> ofertas = new ArrayList<OfertaLaboral>();
    
	public Empleador() {
		super();
	}
	public Empleador(Long cuit, String contrasena, String razonSocial, String nombreComercial,
			LocalDate inicioActividad, String email, Long telefono, String domicilio, String provincia,
			String paginaWeb, String descripcion) {
		super();
		this.cuit = cuit;
		this.contrasena = contrasena;
		this.razonSocial = razonSocial;
		this.nombreComercial = nombreComercial;
		this.inicioActividad = inicioActividad;
		this.email = email;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.provincia = provincia;
		this.paginaWeb = paginaWeb;
		this.descripcion = descripcion;
	}
	public Long getCuit() {
		return cuit;
	}
	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonsSocial) {
		this.razonSocial = razonsSocial;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public LocalDate getInicioActividad() {
		return inicioActividad;
	}
	public void setInicioActividad(LocalDate inicioActividad) {
		this.inicioActividad = inicioActividad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getTelefono() {
		return telefono;
	}
	public void setTelefono(Long telefono) {
		this.telefono = telefono;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPaginaWeb() {
		return paginaWeb;
	}
	public void setPaginaWeb(String paginaWeb) {
		this.paginaWeb = paginaWeb;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<OfertaLaboral> getOfertas() {
		return ofertas;
	}
	public void setOfertas(List<OfertaLaboral> ofertas) {
		this.ofertas = ofertas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
