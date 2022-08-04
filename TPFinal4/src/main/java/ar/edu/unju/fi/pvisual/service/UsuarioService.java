package ar.edu.unju.fi.pvisual.service;

import java.util.List;

import ar.edu.unju.fi.pvisual.model.Usuario;

public interface UsuarioService {

	public List<Usuario> listarUsuario();

	public Usuario guardarUsuario(Usuario usuario);

	public Usuario buscarUsuario(Long id);

	public void eliminarUsuario(Long id);

	public Usuario findByDni(Long dni);
}
