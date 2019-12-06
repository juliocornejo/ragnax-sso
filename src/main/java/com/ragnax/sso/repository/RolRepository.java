package com.ragnax.sso.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.sso.entidad.Rol;


public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	@Query("select r from Rol r where r.nombreRol = :nombreRol")
	Page<Rol> findByNombreRol(String nombreRol, Pageable page);
	
	@Query("select r from Rol r where r.nombreRolLowerCase = :nombreRolLowerCase")
	Page<Rol> findByNombreRolLowerCase(String nombreRolLowerCase, Pageable page);
	
	Rol findByNombreRolLowerCase(String nombreRolLowerCase);

	List<Rol> findByEstadoRol(Boolean estadoRol);
}
