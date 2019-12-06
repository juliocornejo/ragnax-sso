package com.ragnax.sso.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.sso.entidad.AccionPerfil;
import com.ragnax.sso.entidad.Perfil;
import com.ragnax.sso.entidad.TipoAccionPerfil;



public interface AccionPerfilRepository extends JpaRepository<AccionPerfil, Integer> {
	
	AccionPerfil findByidPerfilAndIdTipoAccionPerfilAndKeyAccionPerfil(Perfil idPerfil, TipoAccionPerfil idTipoAccionPerfil, String keyAccionPerfil);
	
	List<AccionPerfil> findByUltimaAccionPerfilBetween(Timestamp ultimaAccionPerfilA , Timestamp ultimaAccionPerfilB);
	
	List<AccionPerfil> findByIdPerfilAndIdTipoAccionPerfil(Perfil idPerfil, TipoAccionPerfil idTipoAccionPerfil);
}
