package com.ragnax.sso.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.sso.entidad.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {
	
	Empresa findByRolUnicoIdentificadorEmpresa(String rolUnicoIdentificadorEmpresa);
	
	Empresa findByNombreEmpresaLowerCase(String nombreEmpresaLowerCase);
	
	@Query("select emp from Empresa emp where emp.dominioEmpresa = :dominioEmpresa")
	Page<Empresa> findByDominioEmpresa(String dominioEmpresa, Pageable page);
	
	@Query("select emp from Empresa emp where emp.nombreEmpresaLowerCase = :nombreEmpresaLowerCase")
	Page<Empresa> findByNombreEmpresaLowerCase(String nombreEmpresaLowerCase, Pageable page);
	
	@Query("select emp from Empresa emp where emp.razonSocialEmpresaLowerCase = :razonSocialEmpresaLowerCase")
	Page<Empresa> findByRazonSocialEmpresaLowerCase(String razonSocialEmpresaLowerCase, Pageable page);
	
	Empresa findByRazonSocialEmpresa(String razonSocialEmpresa);
	
	List<Empresa> findByCodigoPaisPortal(String codigoPaisPortal);
	
	List<Empresa> findByNombreEmpresaLowerCaseLike(String nombreEmpresaLowerCase);
	
	List<Empresa> findByRazonSocialEmpresaLike(String razonSocialEmpresa);
	
	List<Empresa> findByEstadoEmpresa(Boolean estadoEmpresa);
}
