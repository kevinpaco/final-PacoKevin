package ar.edu.unju.fi.pvisual.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.pvisual.model.Curso;
import ar.edu.unju.fi.pvisual.repository.CursoRepository;
import ar.edu.unju.fi.pvisual.service.CursoService;

@Service
public class CursoServiceImp implements CursoService {

	@Autowired 
	private CursoRepository cursoRepository;
	
	@Override
	public List<Curso> listarCurso() {
		// TODO Auto-generated method stub
		return cursoRepository.findAll();
	}

	@Override
	public Curso guardarCurso(Curso curso) {
		// TODO Auto-generated method stub
		return cursoRepository.save(curso);
	}

	@Override
	public Curso buscarCurso(Long id) {
		// TODO Auto-generated method stub
		return cursoRepository.findById(id).get();
	}

}
