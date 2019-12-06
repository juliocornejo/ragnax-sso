package com.ragnax.sso.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.sso.entidad.ConfiguracionEmpresaUsuario;
import com.ragnax.sso.entidad.Empresa;

public interface ConfiguracionEmpresaUsuarioRepository extends JpaRepository<ConfiguracionEmpresaUsuario, Integer> {
	
	@Query("select ceu from ConfiguracionEmpresaUsuario ceu where ceu.idEmpresa = :idEmpresa")
	Page<ConfiguracionEmpresaUsuario> findByIdEmpresa(Empresa idEmpresa, Pageable page);
	
	ConfiguracionEmpresaUsuario findByIdEmpresaAndEstadoConfiguracionEmpresaUsuario(Empresa idEmpresa, Boolean estadoConfiguracionEmpresaUsuario);
	
}
