package ar.edu.unju.fi.pvisual.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;

import ar.edu.unju.fi.pvisual.model.Empleador;
import ar.edu.unju.fi.pvisual.model.Usuario;
import ar.edu.unju.fi.pvisual.repository.IEmpleadorRepository;
import ar.edu.unju.fi.pvisual.repository.UsuarioRepository;

@Service
public class UserDetailsServiceImp implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private IEmpleadorRepository empleadorRepository;

	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Long dni1 = Long.parseLong(dni);

				
		List<GrantedAuthority> tipos = new ArrayList<>();
		
		Usuario usuarioEncontrado = usuarioRepository.findByDni(dni1);
		if (usuarioEncontrado != null) {
			
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipo());
			tipos.add(grantedAuthority);
			UserDetails user = (UserDetails) new User(dni, usuarioEncontrado.getContraseña(), tipos);

			return user;
		} else {
			
			Empleador empleadorEncontrado = empleadorRepository.findByCuit(dni1);
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(empleadorEncontrado.getTipo());
			tipos.add(grantedAuthority);
			UserDetails user = (UserDetails) new User(dni, empleadorEncontrado.getContrasena(), tipos);
			
			return user;			
		}
		/*
		 * UserBuilder builder = null; if(usuarioEncontrado != null) { builder =
		 * org.springframework.security.core.userdetails.User.withUsername(dni);
		 * builder.disabled(false); builder.password(usuarioEncontrado.getContraseña());
		 * builder.authorities(new SimpleGrantedAuthority("ROLE_USER")); }else { throw
		 * new UsernameNotFoundException("usuario no encontrado"); }
		 */

	}

}

