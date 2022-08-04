package ar.edu.unju.fi.pvisual.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.pvisual.model.Curriculum;
import ar.edu.unju.fi.pvisual.repository.ICurriculumRepository;
import ar.edu.unju.fi.pvisual.service.CurriculumService;

@Service
public class CurriculumServiceImp implements CurriculumService{

	@Autowired
	ICurriculumRepository usuarioRepository;

	@Override
	public List<Curriculum> listarCurriculum() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	@Override
	public Curriculum guardarCurricullum(Curriculum curriculum) {
		// TODO Auto-generated method stub
		return usuarioRepository.save(curriculum);
	}

	@Override
	public Curriculum buscarCurricullum(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findById(id).get();
	}

	@Override
	public void eliminarCurricullum(Long id) {
		// TODO Auto-generated method stub
		usuarioRepository.deleteById(id);
	}
	
	
}
