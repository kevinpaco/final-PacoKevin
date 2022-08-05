package ar.edu.unju.fi.pvisual.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.pvisual.model.Usuario;
import ar.edu.unju.fi.pvisual.repository.UsuarioRepository;
import ar.edu.unju.fi.pvisual.service.UsuarioService;

@Service
public class UsuarioServiceImp implements UsuarioService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private UsuarioRepository usuarioReposotory;
	
	@Override
	public List<Usuario> listarUsuario() {
		// TODO Auto-generated method stub
		return usuarioReposotory.findAll();
	}

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		usuario.setContraseña(passwordEncoder.encode(usuario.getContraseña()));
		usuario.setTipo("ciudadano");
		return usuarioReposotory.save(usuario);
	}

	@Override
	public Usuario buscarUsuario(Long id) {
		// TODO Auto-generated method stub
		return usuarioReposotory.findById(id).get();
	}

	@Override
	public void eliminarUsuario(Long id) {
		// TODO Auto-generated method stub
		usuarioReposotory.deleteById(id);
	}

	@Override
	public Usuario findByDni(Long dni) {
		// TODO Auto-generated method stub
		return usuarioReposotory.findByDni(dni);
	}

	@Override
	public List<Usuario> filtrarProvincia(String Provincia) {
		// TODO Auto-generated method stub
		if(Provincia == null) {
			return usuarioReposotory.findAll();
		}else {
		return usuarioReposotory.filtrarProvincia(Provincia);}
	}

}
