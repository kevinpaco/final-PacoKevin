package ar.edu.unju.fi.pvisual.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.pvisual.model.Empleador;
import ar.edu.unju.fi.pvisual.model.OfertaLaboral;
import ar.edu.unju.fi.pvisual.repository.IEmpleadorRepository;
import ar.edu.unju.fi.pvisual.repository.OfertaLaboralRepository;
import ar.edu.unju.fi.pvisual.service.OfertaLaboralService;

@Service
public class OfertaLaboralServiceImp implements OfertaLaboralService {

	@Autowired 
	private OfertaLaboralRepository ofertaLaboralRepository;

	@Autowired
	IEmpleadorRepository empleadorRepository;
	@Override
	public List<OfertaLaboral> listarOferta() {
		// TODO Auto-generated method stub
		return ofertaLaboralRepository.findAll();
	}
	
	@Override
	public OfertaLaboral guardarOferta(OfertaLaboral oferta) {
		
		if(oferta.getCantidadVacantes() > 0) {
			oferta.setDisponible(true);
		     return ofertaLaboralRepository.save(oferta);
		}else {
				oferta.setDisponible(false);
			     return ofertaLaboralRepository.save(oferta);			
		}
	}

	@Override
	public OfertaLaboral buscarOferta(Long id) {
		// TODO Auto-generated method stub
		return ofertaLaboralRepository.findById(id).get();
	}
	@Override
	public void eliminarOferta(Long id) {
		// TODO Auto-generated method stub
		ofertaLaboralRepository.deleteById(id);
	}

	@Override
	public List<OfertaLaboral> filtrarOferta(String palabraClave) {
		// TODO Auto-generated method stub
		if(palabraClave != null) {
		return ofertaLaboralRepository.filtrarOferta(palabraClave);
		}
		return ofertaLaboralRepository.findAll();
	}

}
