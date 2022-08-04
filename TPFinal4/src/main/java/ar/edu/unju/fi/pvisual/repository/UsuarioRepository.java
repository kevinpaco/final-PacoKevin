package ar.edu.unju.fi.pvisual.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.pvisual.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	//@Query("SELECT p FROM Usuarios p WHERE" + " CONCAT(p.dni)" + " LIKE %?1%")
	public Usuario findByDni(Long dni); 

}
