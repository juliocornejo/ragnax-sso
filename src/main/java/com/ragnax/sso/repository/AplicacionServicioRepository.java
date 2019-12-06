package com.ragnax.sso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.sso.entidad.Aplicacion;
import com.ragnax.sso.entidad.AplicacionServicio;

public interface AplicacionServicioRepository extends JpaRepository<AplicacionServicio, Integer> {
	
	AplicacionServicio findByIdAplicacionAndUriRutaAplicacionAndUriRutaAplicacionProductoAndUriRutaAplicacionProductoServicioAndMetodoHttp(
			Aplicacion idAplicacion,
			String uriRutaAplicacion, 
			String uriRutaAplicacionProducto, 
			String uriRutaAplicacionProductoServicio, 
			String metodoHttp);
	
	List<AplicacionServicio> findByIdAplicacion(Aplicacion idAplicacion);
}

