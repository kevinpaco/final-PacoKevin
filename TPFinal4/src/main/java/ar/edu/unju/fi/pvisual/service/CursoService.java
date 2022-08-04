package ar.edu.unju.fi.pvisual.service;

import java.util.List;

import ar.edu.unju.fi.pvisual.model.Curso;

public interface CursoService {

	public List<Curso> listarCurso();
	public Curso guardarCurso(Curso curso);
	public Curso buscarCurso(Long id);
}
