package ar.edu.unju.fi.pvisual.service;

import java.util.List;

import ar.edu.unju.fi.pvisual.model.Curriculum;

public interface CurriculumService {

	
	public List<Curriculum> listarCurriculum();
	public Curriculum guardarCurricullum(Curriculum curriculum);
	public Curriculum buscarCurricullum(Long id);
	public void eliminarCurricullum(Long id);
}
