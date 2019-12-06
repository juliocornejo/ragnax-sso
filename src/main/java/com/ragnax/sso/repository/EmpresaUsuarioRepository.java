package com.ragnax.sso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.sso.entidad.Empresa;
import com.ragnax.sso.entidad.EmpresaUsuario;
import com.ragnax.sso.entidad.Rol;
import com.ragnax.sso.entidad.Usuario;

public interface EmpresaUsuarioRepository extends JpaRepository<EmpresaUsuario, Integer> {
	
	EmpresaUsuario findByIdEmpresaAndIdUsuarioAndIdRol(Empresa idEmpresa, Usuario idUsuario, Rol idRol);
	List<EmpresaUsuario> findByEstadoEmpresaUsuario(Boolean estadoEmpresaUsuario);
	List<EmpresaUsuario> findByIdEmpresa(Empresa idEmpresa);
	List<EmpresaUsuario> findByIdUsuario(Usuario idUsuario);
	List<EmpresaUsuario> findByIdEmpresaAndIdRol(Empresa idEmpresa, Rol idRol);
	
	
}
