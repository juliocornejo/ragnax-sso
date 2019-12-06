package com.ragnax.sso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.sso.entidad.AplicacionServicio;
import com.ragnax.sso.entidad.EmpresaUsuarioAplicacionEmpresa;
import com.ragnax.sso.entidad.SeguridadAplicacionAcceso;


public interface SeguridadAplicacionAccesoRepository extends JpaRepository<SeguridadAplicacionAcceso, Integer> {
	
	SeguridadAplicacionAcceso findByIdEmpresaUsuarioAplicacionEmpresaAndIdAplicacionServicio(
			EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa,
			AplicacionServicio idAplicacionServicio);
	
	List<SeguridadAplicacionAcceso> findByIdEmpresaUsuarioAplicacionEmpresaAndIdAplicacionServicioInAndEstadoSeguridadAplicacionAcceso(
			EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa,
			List<AplicacionServicio> listaAplicacionServicio,
			Boolean estadoSeguridadAplicacionAcceso);
	
	
	List<SeguridadAplicacionAcceso> findByIdEmpresaUsuarioAplicacionEmpresaAndEstadoSeguridadAplicacionAcceso(
			EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa,
			Boolean estadoSeguridadAplicacionAcceso);
}
