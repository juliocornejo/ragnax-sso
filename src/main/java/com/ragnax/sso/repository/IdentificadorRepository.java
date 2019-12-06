package com.ragnax.sso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.sso.entidad.Identificador;
import com.ragnax.sso.entidad.Member;

public interface IdentificadorRepository extends JpaRepository<Identificador, Integer> {
	
	Identificador findByValueIdentificadorAndNombreIdentificadorAndCodigoPaisPortal(String valueIdentificador, String nombreIdentificador, String codigoPaisPortal);
	
	List<Identificador> findByIdMember(Member idMember);
	
}
