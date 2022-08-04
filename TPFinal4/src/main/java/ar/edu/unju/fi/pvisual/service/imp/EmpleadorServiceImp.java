package ar.edu.unju.fi.pvisual.service.imp;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import ar.edu.unju.fi.pvisual.model.Empleador;
import ar.edu.unju.fi.pvisual.repository.IEmpleadorRepository;
import ar.edu.unju.fi.pvisual.service.IEmpleadorService;



@Service
public class EmpleadorServiceImp implements IEmpleadorService{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private IEmpleadorRepository empleadorRepository;
	
	@Override
	public Empleador guardarEmpleador(Empleador empleador) {
		// TODO Auto-generated method stub
		
		empleador.setTipo("empleador");
		empleador.setContrasena(passwordEncoder.encode(empleador.getContrasena()));
		return empleadorRepository.save(empleador);
	}

	@Override
	public List<Empleador> listarEmplador() {
		// TODO Auto-generated method stub
		return empleadorRepository.findAll();
	}

	@Override
	public Empleador bucarEmpleador(Long id) {
		// TODO Auto-generated method stub
		return empleadorRepository.findById(id).get();
	}

	@Override
	public void eliminarEmpleador(Long id) {
		// TODO Auto-generated method stub
		empleadorRepository.deleteById(id);
	}

	@Override
	public Empleador findByCuit(Long ciut) {
		// TODO Auto-generated method stub
		return empleadorRepository.findByCuit(ciut);
	}

}
