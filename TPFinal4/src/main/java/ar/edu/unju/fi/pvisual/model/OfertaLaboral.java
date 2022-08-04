package ar.edu.unju.fi.pvisual.model;

import java.util.ArrayList; 
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Component
@Entity
@Table(name = "Ofertas_Laborales")
public class OfertaLaboral {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="Oferta_ID")
	private long id;
	
	@Column(name = "PUESTO_REQUERIDO")
	private String puestorequerido;
	
	@Column(name = "CANTIDAD_VACANTES")
	private int cantidadVacantes;
	
	@Column(name = "RESUMEN_PUESTO")
	private String resumenPuesto;
	
	@Column(name = "DISPONIBILIDAD_HORARIA")
	private String disponHoraria;
	
	@Column(name = "PRINCIPALES_TAREAS")
	private String principalesTareas;
	
	@Column(name = "DATOS_CONTACTO")
	private long datosContacto;
	
	@Column(name = "JORNADA")
	private  String Jornada;
	
	@Column(name = "REQUISITOS")
	private String requisitos;
	
	@Column(name = "SALARIO")
	private double salario;
	
	@Column(name = "BENEFICIOS")
	private String beneficios;
	
	@Column(name = "DISPONIBLE")
	private boolean disponible;
	
	@Autowired
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "empleador_id")
	private Empleador empleador2; 
	
	@ManyToMany
	@JsonBackReference
	@JoinTable(name = "OfertasLaborales_Usuarios",
	joinColumns = @JoinColumn(name = "Oferta_ID", referencedColumnName = "Oferta_ID"),
	inverseJoinColumns = @JoinColumn(name = "id", referencedColumnName = "id")) 
	private List<Usuario> usuario = new ArrayList<>();
	
	public void añadirUsuario(Usuario usuario) {
		this.usuario.add(usuario);
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public OfertaLaboral() {
		super();
	}
	public OfertaLaboral(int cantidadVacantes, String puestorequerido, String resumenPuesto, String disponHoraria,
			String principalesTareas, long datosContacto, String jornada, String requisitos, double salario,
			String beneficios, boolean disponible) {
		super();
		this.cantidadVacantes = cantidadVacantes;
		this.puestorequerido = puestorequerido;
		this.resumenPuesto = resumenPuesto;
		this.disponHoraria = disponHoraria;
		this.principalesTareas = principalesTareas;
		this.datosContacto = datosContacto;
		this.Jornada = jornada;
		this.requisitos = requisitos;
		this.salario = salario;
		this.beneficios = beneficios;
		this.disponible = disponible;
	}
	public int getCantidadVacantes() {
		return cantidadVacantes;
	}
	public void setCantidadVacantes(int cantidadVacantes) {
		this.cantidadVacantes = cantidadVacantes;
	}
	public String getPuestorequerido() {
		return puestorequerido;
	}
	public void setPuestorequerido(String puestorequerido) {
		this.puestorequerido = puestorequerido;
	}
	public String getResumenPuesto() {
		return resumenPuesto;
	}
	public void setResumenPuesto(String resumenPuesto) {
		this.resumenPuesto = resumenPuesto;
	}
	public String getDisponHoraria() {
		return disponHoraria;
	}
	public void setDisponHoraria(String disponHoraria) {
		this.disponHoraria = disponHoraria;
	}
	public String getPrincipalesTareas() {
		return principalesTareas;
	}
	public void setPrincipalesTareas(String principalesTareas) {
		this.principalesTareas = principalesTareas;
	}
	public long getDatosContacto() {
		return datosContacto;
	}
	public void setDatosContacto(long datosContacto) {
		this.datosContacto = datosContacto;
	}
	public String getJornada() {
		return Jornada;
	}
	public void setJornada(String jornada) {
		Jornada = jornada;
	}
	public String getRequisitos() {
		return requisitos;
	}
	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public String getBeneficios() {
		return beneficios;
	}
	public void setBeneficios(String beneficios) {
		this.beneficios = beneficios;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	public Empleador getEmpleador() {
		return empleador2;
	}
	public void setEmpleador(Empleador empleador) {
		this.empleador2 = empleador;
	}
	


	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "OfertasLaborales [id=" + id + ", puestorequerido=" + puestorequerido + ", cantidadVacantes="
				+ cantidadVacantes + ", resumenPuesto=" + resumenPuesto + ", disponHoraria=" + disponHoraria
				+ ", principalesTareas=" + principalesTareas + ", datosContacto=" + datosContacto + ", Jornada="
				+ Jornada + ", requisitos=" + requisitos + ", salario=" + salario + ", beneficios=" + beneficios
				+ ", disponible=" + disponible + ", empleador2=" + empleador2 + ", usuario= " + usuario + "]";
	}
	

}