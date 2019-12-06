package com.ragnax.sso.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.sso.entidad.TipoAccionPerfil;


public interface TipoAccionPerfilRepository extends JpaRepository<TipoAccionPerfil, Integer> {
	
	@Query("select g from TipoAccionPerfil g where g.nombreTipoAccionPerfil = :nombreTipoAccionPerfil")
	Page<TipoAccionPerfil> findByNombreTipoAccionPerfil(String nombreTipoAccionPerfil, Pageable page);
}
