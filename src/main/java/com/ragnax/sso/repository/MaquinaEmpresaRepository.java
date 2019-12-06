package com.ragnax.sso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.sso.entidad.Empresa;
import com.ragnax.sso.entidad.Maquina;
import com.ragnax.sso.entidad.MaquinaEmpresa;


public interface MaquinaEmpresaRepository extends JpaRepository<MaquinaEmpresa, Integer> {
	
	MaquinaEmpresa findByIdMaquinaAndIdEmpresa(Maquina idMaquina, Empresa idEmpresa);
	
	List<MaquinaEmpresa> findByIdEmpresa(Empresa idEmpresa);
	
}
