package com.ragnax.sso.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.sso.entidad.Perfil;


public interface PerfilRepository extends JpaRepository<Perfil, Integer> {
	
	@Query("select p from Perfil p where p.usernamePerfil = :usernamePerfil")
	Page<Perfil> findByUsernamePerfil(String usernamePerfil, Pageable page);
	
	Perfil findByUsernamePerfilAndPasswordContrasenha(String usernamePerfil, String passwordContrasenha);
	
	@Query("select p from Perfil p where p.nombrePerfilLowerCase = :nombrePerfilLowerCase")
	Page<Perfil> findByNombrePerfilLowerCase(String nombrePerfilLowerCase, Pageable page);
	
	
	@Query("select p from Perfil p where p.emailPerfil = :emailPerfil")
	Page<Perfil> findByEmailPerfil(String emailPerfil, Pageable page);
	
	Perfil findByPasswordRespuesta(String passwordRespuesta);
	
	@Query("select p from Perfil p where p.usernamePerfil like %:usernamePerfil%")
	List<Perfil> findByUsernamePerfilLike(String usernamePerfil);
	
	List<Perfil> findByNombrePerfilLowerCaseLike(String nombrePerfilLowerCase);
	
	List<Perfil> findByEmailPerfilLike(String emailPerfil);
	
	List<Perfil> findByEstadoUsuarioPerfil(Boolean estadoUsuarioPerfil);
	
	List<Perfil> findByAnonimo(Integer anonimo);
	
	List<Perfil> findByUltimaAccionUsuarioBetween(Timestamp ultimaAccionUsuarioA, Timestamp ultimaAccionUsuarioB);
	
	List<Perfil> findByUltimaConexionPerfilBetween(Timestamp ultimaConexionPerfilA, Timestamp ultimaConexionPerfilB);
	
	List<Perfil> findByPasswordUltimaActualizacionBetween(Timestamp passwordUltimaActualizacionA, Timestamp passwordUltimaActualizacionB);
	
	List<Perfil> findByEstadoPerfilLastBloqueadoBetween(Timestamp estadoPerfilLastBloqueadoA, Timestamp estadoPerfilLastBloqueadoB);
}
