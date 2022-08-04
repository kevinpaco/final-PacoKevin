package ar.edu.unju.fi.pvisual.repository;

import java.util.List; 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.pvisual.model.Empleador;

@Repository
public interface IEmpleadorRepository extends JpaRepository<Empleador, Long>{
	
	public Empleador findByCuit(Long ciut);
	
}
