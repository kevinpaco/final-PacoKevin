package ar.edu.unju.fi.pvisual.service;

import java.util.List;

import ar.edu.unju.fi.pvisual.model.Empleador;
import ar.edu.unju.fi.pvisual.model.OfertaLaboral;

public interface OfertaLaboralService {

	public List<OfertaLaboral> listarOferta();

	public OfertaLaboral guardarOferta(OfertaLaboral oferta);

	public OfertaLaboral buscarOferta(Long id);

	public void eliminarOferta(Long id);
	
	public List<OfertaLaboral> filtrarOferta(String palabraClave);
}
