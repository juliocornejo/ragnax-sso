package com.ragnax.sso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.sso.entidad.Aplicacion;
import com.ragnax.sso.entidad.AplicacionEmpresa;
import com.ragnax.sso.entidad.Empresa;


public interface AplicacionEmpresaRepository extends JpaRepository<AplicacionEmpresa, Integer> {
	
	AplicacionEmpresa findByIdAplicacionAndIdEmpresa(Aplicacion idAplicacion, Empresa idEmpresa);
	List<AplicacionEmpresa> findByIdAplicacionAndEstadoAplicacionEmpresa(Aplicacion idAplicacion, Boolean estadoAplicacionEmpresa);
	List<AplicacionEmpresa> findByIdEmpresa(Empresa idEmpresa);
	List<AplicacionEmpresa> findByEstadoAplicacionEmpresa(Boolean estadoAplicacionEmpresa);
}
