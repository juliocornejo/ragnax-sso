package com.ragnax.sso.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.sso.entidad.Aplicacion;

public interface AplicacionRepository extends JpaRepository<Aplicacion, Integer> {
	
	@Query("select ap from Aplicacion ap where ap.uriRuta = :uriRuta")
	Page<Aplicacion> findByUriRuta(String uriRuta, Pageable page);
	
	@Query("select a from Aplicacion a where a.nombreAplicacionLowerCase = :nombreAplicacionLowerCase")
	Page<Aplicacion> findByNombreAplicacionLowerCase(String nombreAplicacionLowerCase, Pageable page);
	
	Aplicacion findByNombreAplicacionLowerCase( String nombreAplicacionLowerCase);
	
	List<Aplicacion > findByNombreAplicacionLowerCaseLike( String nombreAplicacionLowerCase);
	
	List<Aplicacion > findByNombreAplicacionIn(List<String> listaNombreAplicacion);
	
}
