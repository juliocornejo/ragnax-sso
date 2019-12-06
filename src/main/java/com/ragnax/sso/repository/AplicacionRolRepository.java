package com.ragnax.sso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.sso.entidad.Aplicacion;
import com.ragnax.sso.entidad.AplicacionRol;
import com.ragnax.sso.entidad.Rol;


public interface AplicacionRolRepository extends JpaRepository<AplicacionRol, Integer> {
	
	AplicacionRol findByIdAplicacionAndIdRol(Aplicacion idAplicacion, Rol idRol);
	
	List<AplicacionRol> findByIdAplicacion(Aplicacion idAplicacion);
	
	List<AplicacionRol> findByIdRol(Rol idRol);
	
}
