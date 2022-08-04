package ar.edu.unju.fi.pvisual.service;

import java.util.List; 

import ar.edu.unju.fi.pvisual.model.Empleador;

public interface IEmpleadorService {

	public List<Empleador> listarEmplador();

	public Empleador guardarEmpleador(Empleador empleador);

	public Empleador bucarEmpleador(Long id);

	public void eliminarEmpleador(Long id);
	
	public Empleador findByCuit(Long ciut);

}
