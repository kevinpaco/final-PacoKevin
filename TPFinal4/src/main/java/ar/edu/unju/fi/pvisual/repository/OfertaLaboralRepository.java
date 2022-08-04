package ar.edu.unju.fi.pvisual.repository;

import java.util.List; 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import ar.edu.unju.fi.pvisual.model.Empleador;
import ar.edu.unju.fi.pvisual.model.OfertaLaboral;
import ar.edu.unju.fi.pvisual.model.Usuario;

@Repository
public interface OfertaLaboralRepository extends JpaRepository<OfertaLaboral, Long >{
	
	@Query("SELECT p FROM OfertaLaboral p WHERE" + " CONCAT(p.puestorequerido)" + " LIKE %?1%")
	public List<OfertaLaboral> filtrarOferta(String palabraClave);
}
