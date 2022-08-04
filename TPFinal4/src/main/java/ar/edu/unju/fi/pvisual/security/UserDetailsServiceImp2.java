package ar.edu.unju.fi.pvisual.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.pvisual.model.Empleador;
import ar.edu.unju.fi.pvisual.repository.IEmpleadorRepository;

@Service
public class UserDetailsServiceImp2 implements UserDetailsService {

	@Autowired 
	private IEmpleadorRepository empleadorRepository;
	
	@Override
	public UserDetails loadUserByUsername(String cuit) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Long cuit1 = Long.parseLong(cuit);
		
		Empleador empleadorEncontrado = empleadorRepository.findByCuit(cuit1);
		
		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority2 = new SimpleGrantedAuthority(empleadorEncontrado.getTipo());
		tipos.add(grantedAuthority2);
		
		UserDetails user = (UserDetails) new User(cuit, empleadorEncontrado.getContrasena(), tipos);
		return user;
	}

}
