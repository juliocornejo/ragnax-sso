package com.ragnax.sso.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ragnax.sso.entidad.Maquina;


public interface MaquinaRepository extends JpaRepository<Maquina, Integer> {
	
	Maquina findByDireccionIpMaquina(String direccionIpMaquina);
	
	@Query("select maq from Maquina maq where maq.direccionIpMaquina = :direccionIpMaquina")
	Page<Maquina> findByDireccionIpMaquina(String direccionIpMaquina, Pageable page);
	
	List<Maquina> findByDireccionIpMaquinaIn(List<String> listaDireccionIpMaquina);
}
