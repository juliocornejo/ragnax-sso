package com.ragnax.sso.servicio;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ragnax.sso.configuration.FactoryApiProperties;
import com.ragnax.sso.controller.response.SSO;
import com.ragnax.sso.entidad.AccionPerfil;
import com.ragnax.sso.entidad.Aplicacion;
import com.ragnax.sso.entidad.AplicacionEmpresa;
import com.ragnax.sso.entidad.AplicacionRol;
import com.ragnax.sso.entidad.AplicacionServicio;
import com.ragnax.sso.entidad.ConfiguracionEmpresaUsuario;
import com.ragnax.sso.entidad.Empresa;
import com.ragnax.sso.entidad.EmpresaUsuario;
import com.ragnax.sso.entidad.EmpresaUsuarioAplicacionEmpresa;
import com.ragnax.sso.entidad.FotoPerfil;
import com.ragnax.sso.entidad.Genero;
import com.ragnax.sso.entidad.Identificador;
import com.ragnax.sso.entidad.Maquina;
import com.ragnax.sso.entidad.MaquinaEmpresa;
import com.ragnax.sso.entidad.Member;
import com.ragnax.sso.entidad.Perfil;
import com.ragnax.sso.entidad.Rol;
import com.ragnax.sso.entidad.SeguridadAplicacionAcceso;
import com.ragnax.sso.entidad.TipoAccionPerfil;
import com.ragnax.sso.entidad.Usuario;
import com.ragnax.sso.exception.LogicaImplException;
import com.ragnax.sso.repository.FactorySeguridadDAO;
import com.ragnax.sso.servicio.clientes.ZapalaClienteRest;
import com.ragnax.sso.servicio.clientes.modelo.ZapalaRequest;
import com.ragnax.sso.servicio.utilidades.SSOUtilidades;


@Service
@ComponentScan(basePackageClasses = { FactoryApiProperties.class})
public class SSOServiceImpl implements SSOService {
	//Segun se necesite se van creando llamadas al repositorio para devolver entities.
	@Autowired
	private FactorySeguridadDAO factorySeguridadDAO;
	
	@Autowired
	private ZapalaClienteRest zapalaClienteRest;
	
	@Autowired
	private FactoryApiProperties factoryApiProperties;
	
	/******* Rol Rol Rol *****************/
	/******* Rol Rol Rol *****************/
	/******* Rol Rol Rol *****************/
	public SSO crearRol(Rol objRol) throws LogicaImplException {
		
		SSO seguridadAplicaciones = new SSO();

		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreRolLowerCase").descending());

			Page<Rol> pageNombreLowerRol  = factorySeguridadDAO.getRolRepository().findByNombreRolLowerCase(objRol.getNombreRol().toLowerCase(), pageByNombreDesc);

			if(pageNombreLowerRol.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idRol").descending());

				Page<Rol> pageIdRol = factorySeguridadDAO.getRolRepository().findAll(pageByidDesc);

				Integer idRol = (!pageIdRol.isEmpty()) ? (Integer) pageIdRol.getContent().get(0).getIdRol() + 1 : 1; 

				objRol.setIdRol(idRol);
				
				objRol.setNombreRolLowerCase(objRol.getNombreRol().toLowerCase());
				
				objRol.setEstadoRol(Boolean.parseBoolean(factoryApiProperties.getConfigdata().getEstadoActivoConsulta()));
				
				factorySeguridadDAO.getRolRepository().save(objRol);

				objRol  = buscarRolxNombre(objRol).getRol();

				seguridadAplicaciones.setRol(objRol);
			
			}else {
				throw new LogicaImplException("No se puede crear Rol, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
//	public SeguridadAplicaciones buscarRol(Rol objRol) throws LogicaImplException {
//
//		SeguridadAplicaciones seguridadAplicaciones = new SeguridadAplicaciones();
//
//		try {
//			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
//			
//
//			Optional<Rol> optRolDesc  = factorySeguridadDAO.getRolRepository().findById(objRol.getIdRol());
//
//			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
//				//... solo actualizar estado****/
//			if(optRolDesc.isPresent()){
//
//				seguridadAplicaciones.setRol(optRolDesc.get());
//			}
//			else {
//				throw new LogicaImplException("No existe Rol con nombre:" +objRol.getNombreRol());
//			}
//
//		} catch (Exception e) {
//			throw new LogicaImplException(e.getMessage());
//		}
//		return seguridadAplicaciones;
//	}
	
	public SSO buscarRolxNombre(Rol objRol) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreRolLowerCase").descending());

			Page<Rol> pageNombreDesc  = factorySeguridadDAO.getRolRepository().findByNombreRol(
					objRol.getNombreRol().toLowerCase(), pageByNombreDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				//... solo actualizar estado****/
			if(!pageNombreDesc.isEmpty()){

				seguridadAplicaciones.setRol(pageNombreDesc.getContent().get(0));
			}
			else {
				throw new LogicaImplException("No existe Rol con nombre:" +objRol.getNombreRol());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO listarTodoRol() throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			List<Rol> listaRol = factorySeguridadDAO.getRolRepository().findAll();

			if(listaRol!=null && !listaRol.isEmpty()){
				seguridadAplicaciones.setListaRol(listaRol);
			}else {
				throw new LogicaImplException("No existe lista de Rol");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	/*******************************************/
	/***** Aplicacion Aplicacion Aplicacion ****/
	/*******************************************/
	public SSO crearAplicacion(Aplicacion objAplicacion) throws LogicaImplException {
		
		SSO seguridadAplicaciones = new SSO();

		try {
			Timestamp tsInicial = new Timestamp(new Date().getTime());
			
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreAplicacionLowerCase").descending());

			Page<Aplicacion> pageNombreLowerAplicacion  = factorySeguridadDAO.getAplicacionRepository().findByNombreAplicacionLowerCase(objAplicacion.getNombreAplicacion().toLowerCase(), pageByNombreDesc);
			
			Pageable pageByUriDesc = PageRequest.of(0, 1, Sort.by("uriRuta").descending());

			Page<Aplicacion> pageUriRutaDesc  = factorySeguridadDAO.getAplicacionRepository().findByUriRuta(
					objAplicacion.getUriRuta(), pageByUriDesc);
			
			if(pageNombreLowerAplicacion.isEmpty() && pageUriRutaDesc.isEmpty()){
				
//				String ahoraYYYY_MM_ddTHH_MM_SSZ = AppDate.obtenerFechaEnFormato(new Date(), TipoFormatoFecha.YYYY_MM_ddTHH_MM_SSZ);
				
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idAplicacion").descending());

				Page<Aplicacion> pageIdAplicacion = factorySeguridadDAO.getAplicacionRepository().findAll(pageByidDesc);

				Integer idAplicacion = (!pageIdAplicacion.isEmpty()) ? (Integer) pageIdAplicacion.getContent().get(0).getIdAplicacion()+1 : 1; 

				objAplicacion.setIdAplicacion(idAplicacion);
				
				objAplicacion.setNombreAplicacionLowerCase(objAplicacion.getNombreAplicacion().toLowerCase());
				
				objAplicacion.setFechaCreacionAplicacion(tsInicial);
				
				factorySeguridadDAO.getAplicacionRepository().save(objAplicacion);

				objAplicacion = buscarAplicacionxUriRuta(objAplicacion).getAplicacion();

				seguridadAplicaciones.setAplicacion(objAplicacion);
			}else {
				throw new LogicaImplException("No se puede crear Aplicacion, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	public SSO buscarAplicacion(Aplicacion objAplicacion) throws LogicaImplException {
		
		SSO seguridadAplicaciones = new SSO();

		try {

			Optional<Aplicacion> optAplicacionDesc  = factorySeguridadDAO.getAplicacionRepository().findById(objAplicacion.getIdAplicacion());

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				//... solo actualizar estado****/
			if(optAplicacionDesc.isPresent()){

				seguridadAplicaciones.setAplicacion(optAplicacionDesc.get());
			}
			else {
				throw new LogicaImplException("No existe Aplicacion con nombre:" +objAplicacion.getNombreAplicacion());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	
	public SSO buscarAplicacionxUriRuta(Aplicacion objAplicacion) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByUriDesc = PageRequest.of(0, 1, Sort.by("uriRuta").descending());

			Page<Aplicacion> pageUriRutaDesc  = factorySeguridadDAO.getAplicacionRepository().findByUriRuta(
					objAplicacion.getUriRuta(), pageByUriDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				//... solo actualizar estado****/
			if(!pageUriRutaDesc.isEmpty()){

				seguridadAplicaciones.setAplicacion(pageUriRutaDesc.getContent().get(0));
			}
			else {
				throw new LogicaImplException("No existe Aplicacion con uri ruta:" +objAplicacion.getUriRuta());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO listarTodoAplicacion() throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			List<Aplicacion> listaAplicacion = factorySeguridadDAO.getAplicacionRepository().findAll();

			if(listaAplicacion!=null && !listaAplicacion.isEmpty()){
				seguridadAplicaciones.setListaAplicacion(listaAplicacion);
			}else {
				throw new LogicaImplException("No existe lista de Aplicacion");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	/*******************************************/
	/***** Maquina Maquina Maquina *************/
	/*******************************************/
	public SSO crearMaquina(Maquina objMaquina) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {

			Pageable pageByDireccionDesc = PageRequest.of(0, 1, Sort.by("direccionIpMaquina").descending());

			Page<Maquina> pageDireccionMaquina  = factorySeguridadDAO.getMaquinaRepository().findByDireccionIpMaquina(objMaquina.getDireccionIpMaquina(), pageByDireccionDesc);

			if(pageDireccionMaquina.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idMaquina").descending());

				Page<Maquina> pageIdMaquina = factorySeguridadDAO.getMaquinaRepository().findAll(pageByidDesc);

				Integer idMaquina = (!pageIdMaquina.isEmpty()) ? (Integer) pageIdMaquina.getContent().get(0).getIdMaquina()+1 : 1; 

				objMaquina.setIdMaquina(idMaquina);

				factorySeguridadDAO.getMaquinaRepository().save(objMaquina);

				objMaquina = buscarMaquinaxDireccionIpMaquina(objMaquina).getMaquina();

				seguridadAplicaciones.setMaquina(objMaquina);
			} else {
				throw new LogicaImplException("No se puede crear Maquina, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	public SSO buscarMaquinaxDireccionIpMaquina(Maquina objMaquina) throws LogicaImplException {
		
		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByDireccionDesc = PageRequest.of(0, 1, Sort.by("direccionIpMaquina").descending());

			Page<Maquina> pageDireccionDesc  = factorySeguridadDAO.getMaquinaRepository().findByDireccionIpMaquina(
					objMaquina.getDireccionIpMaquina(), pageByDireccionDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				//... solo actualizar estado****/
			if(!pageDireccionDesc.isEmpty()){

				seguridadAplicaciones.setMaquina(pageDireccionDesc.getContent().get(0));
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objMaquina.getDireccionIpMaquina());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	/********************************************************/
	/********** Genero Genero Genero ************************/
	/********************************************************/
	public SSO crearGenero(Genero objGenero) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreGenero").descending());

			Page<Genero> pageNombreLowerGenero  = factorySeguridadDAO.getGeneroRepository().
					findByNombreGenero(objGenero.getNombreGenero(), pageByNombreDesc);

			if(pageNombreLowerGenero.isEmpty()){
				
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idGenero").descending());

				Page<Genero> pageIdGenero = factorySeguridadDAO.getGeneroRepository().findAll(pageByidDesc);

				Integer idGenero = (!pageIdGenero.isEmpty()) ? (Integer) pageIdGenero.getContent().get(0).getIdGenero()+1 : 1; 

				objGenero.setIdGenero(idGenero);
				
				objGenero.setEstadoGenero(Boolean.parseBoolean(factoryApiProperties.getConfigdata().getEstadoActivoConsulta()));

				factorySeguridadDAO.getGeneroRepository().save(objGenero);

				objGenero  = buscarGeneroxNombre(objGenero).getGenero();

				seguridadAplicaciones.setGenero(objGenero);
			}else {
				throw new LogicaImplException("No se puede crear Genero, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
//	public SeguridadAplicaciones buscarGenero(Genero objGenero) throws LogicaImplException {
//		SeguridadAplicaciones seguridadAplicaciones = new SeguridadAplicaciones();
//		
//		try {
//
//			Optional<Genero> optGeneroDesc  = factorySeguridadDAO.getGeneroRepository().findById(objGenero.getIdGenero());
//
//			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
//				//... solo actualizar estado****/
//			if(optGeneroDesc.isPresent()){
//
//				seguridadAplicaciones.setGenero(optGeneroDesc.get());
//			}
//			else {
//				throw new LogicaImplException("No existe Genero con nombre:" +objGenero.getNombreGenero());
//			}
//
//		} catch (Exception e) {
//			throw new LogicaImplException(e.getMessage());
//		}
//		return seguridadAplicaciones;
//	}
	
	public SSO buscarGeneroxNombre(Genero objGenero) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreGenero").descending());

			Page<Genero> pageNombreDesc  = factorySeguridadDAO.getGeneroRepository().
					findByNombreGenero(objGenero.getNombreGenero(), pageByNombreDesc);
			
			if(!pageNombreDesc.isEmpty()){
				seguridadAplicaciones.setGenero(pageNombreDesc.getContent().get(0));
			}
			else {
				throw new LogicaImplException("No existe Genero con nombre:" +objGenero.getNombreGenero());
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO listarTodoGenero() throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			List<Genero> listaGenero = factorySeguridadDAO.getGeneroRepository().findAll();

			if(listaGenero!=null && !listaGenero.isEmpty()){
				seguridadAplicaciones.setListaGenero(listaGenero);
			}else {
				throw new LogicaImplException("No existe lista de Genero");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	/********************************************************/
	/********** TipoAccionPerfil TipoAccionPerfil************/
	/********************************************************/
	public SSO crearTipoAccionPerfil(TipoAccionPerfil objTipoAccionPerfil) throws LogicaImplException {
		
		SSO seguridadAplicaciones = new SSO();

		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreTipoAccionPerfil").descending());

			Page<TipoAccionPerfil> pageNombreLowerTipoAccionPerfil  = factorySeguridadDAO.getTipoAccionPerfilRepository().findByNombreTipoAccionPerfil(objTipoAccionPerfil.getNombreTipoAccionPerfil(), pageByNombreDesc);

			if(pageNombreLowerTipoAccionPerfil.isEmpty()){
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idTipoAccionPerfil").descending());

				Page<TipoAccionPerfil> pageIdTipoAccionPerfil = factorySeguridadDAO.getTipoAccionPerfilRepository().findAll(pageByidDesc);

				Integer idTipoAccionPerfil = (!pageIdTipoAccionPerfil.isEmpty()) ? (Integer) pageIdTipoAccionPerfil.getContent().get(0).getIdTipoAccionPerfil()+1 : 1; 

				objTipoAccionPerfil.setIdTipoAccionPerfil(idTipoAccionPerfil);
				
				factorySeguridadDAO.getTipoAccionPerfilRepository().save(objTipoAccionPerfil);

				objTipoAccionPerfil  = buscarTipoAccionPerfil(objTipoAccionPerfil).getTipoAccionPerfil();

				seguridadAplicaciones.setTipoAccionPerfil(objTipoAccionPerfil);
			}else {
				throw new LogicaImplException("No se puede crear TipoAccionPerfil, parametros ya existen en identificador valido");
			}
 
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	public SSO buscarTipoAccionPerfil(TipoAccionPerfil objTipoAccionPerfil) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Optional<TipoAccionPerfil> optPerEmpresa = factorySeguridadDAO.getTipoAccionPerfilRepository().findById(objTipoAccionPerfil.getIdTipoAccionPerfil());

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				//... solo actualizar estado****/
			if(optPerEmpresa!=null && optPerEmpresa.isPresent()){

				seguridadAplicaciones.setTipoAccionPerfil(optPerEmpresa.get());

			}else {
				throw new LogicaImplException("No existe TipoAccionPerfil con identificador:" +objTipoAccionPerfil.getIdTipoAccionPerfil());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}

	public SSO listarTodoTipoAccionPerfil() throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			List<TipoAccionPerfil> listaTipoAccionPerfil = factorySeguridadDAO.getTipoAccionPerfilRepository().findAll();

			if(listaTipoAccionPerfil!=null && !listaTipoAccionPerfil.isEmpty()){
				seguridadAplicaciones.setListaTipoAccionPerfil(listaTipoAccionPerfil);
			}else {
				throw new LogicaImplException("No existe lista de TipoAccionPerfil");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	/********************************************************/
	/********** Empresa Empresa Empresa *********************/
	/********************************************************/
	
	public SSO crearEmpresa(Empresa objEmpresa) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {

			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreEmpresa").descending());

			Page<Empresa> pageNombreDesc  = factorySeguridadDAO.getEmpresaRepository().findByNombreEmpresaLowerCase(
					objEmpresa.getNombreEmpresa().toLowerCase(), pageByNombreDesc);

			Pageable pageByDominioDesc = PageRequest.of(0, 1, Sort.by("dominioEmpresa").descending());

			Page<Empresa> pageDominioDesc  = factorySeguridadDAO.getEmpresaRepository().findByDominioEmpresa(
					objEmpresa.getDominioEmpresa(), pageByDominioDesc);

			Pageable pageByRazonSocialDesc = PageRequest.of(0, 1, Sort.by("razonSocialEmpresa").descending());

			Page<Empresa> pageRazonSocialDesc  = factorySeguridadDAO.getEmpresaRepository().findByRazonSocialEmpresaLowerCase(
					objEmpresa.getRazonSocialEmpresa().toLowerCase(), pageByRazonSocialDesc);


			if(pageNombreDesc.isEmpty() && pageDominioDesc.isEmpty() && pageRazonSocialDesc.isEmpty()) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idEmpresa").descending());

				Page<Empresa> pageIdEmpresa = factorySeguridadDAO.getEmpresaRepository().findAll(pageByidDesc);

				Integer idEmpresa = (!pageIdEmpresa.isEmpty()) ? (Integer) pageIdEmpresa.getContent().get(0).getIdEmpresa() +1 : 1; 

				objEmpresa.setIdEmpresa(idEmpresa);

				objEmpresa.setNombreEmpresaLowerCase(objEmpresa.getNombreEmpresa().toLowerCase());

				objEmpresa.setRazonSocialEmpresaLowerCase(objEmpresa.getRazonSocialEmpresa().toLowerCase());

				objEmpresa.setEstadoEmpresa(Boolean.parseBoolean(factoryApiProperties.getConfigdata().getEstadoActivoConsulta()));

				factorySeguridadDAO.getEmpresaRepository().save(objEmpresa);

				objEmpresa = buscarEmpresa(objEmpresa).getEmpresa();

				seguridadAplicaciones.setEmpresa(objEmpresa);

			}else {
				throw new LogicaImplException("No se puede crear Empresa, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	public SSO buscarEmpresa(Empresa objEmpresa) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Optional<Empresa> optPerEmpresa = factorySeguridadDAO.getEmpresaRepository().findById(objEmpresa.getIdEmpresa());

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				//... solo actualizar estado****/
			if(optPerEmpresa!=null && optPerEmpresa.isPresent()){

				seguridadAplicaciones.setEmpresa(optPerEmpresa.get());

			}else {
				throw new LogicaImplException("No existe Empresa con identificador:" +objEmpresa.getIdEmpresa());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO buscarEmpresaxNombre(Empresa objEmpresa) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombreEmpresa").descending());

			Page<Empresa> pageNombreDesc  = factorySeguridadDAO.getEmpresaRepository().findByNombreEmpresaLowerCase(
					objEmpresa.getNombreEmpresa().toLowerCase(), pageByNombreDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				//... solo actualizar estado****/
			if(!pageNombreDesc.isEmpty()){

				seguridadAplicaciones.setEmpresa(pageNombreDesc.getContent().get(0));
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objEmpresa.getNombreEmpresa());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO buscarEmpresaxDominio(Empresa objEmpresa) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByDominioDesc = PageRequest.of(0, 1, Sort.by("dominioEmpresa").descending());

			Page<Empresa> pageDominioDesc  = factorySeguridadDAO.getEmpresaRepository().findByDominioEmpresa(
					objEmpresa.getDominioEmpresa(), pageByDominioDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				//... solo actualizar estado****/
			if(!pageDominioDesc.isEmpty()){

				seguridadAplicaciones.setEmpresa(pageDominioDesc.getContent().get(0));
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objEmpresa.getDominioEmpresa());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO buscarEmpresaxRazonSocial(Empresa objEmpresa) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByRazonSocialDesc = PageRequest.of(0, 1, Sort.by("razonSocialEmpresa").descending());

			Page<Empresa> pageRazonSocialDesc  = factorySeguridadDAO.getEmpresaRepository().findByRazonSocialEmpresaLowerCase(
					objEmpresa.getRazonSocialEmpresa().toLowerCase(), pageByRazonSocialDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
				//... solo actualizar estado****/
			if(!pageRazonSocialDesc.isEmpty()){

				seguridadAplicaciones.setEmpresa(pageRazonSocialDesc.getContent().get(0));
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objEmpresa.getNombreEmpresa());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
		public SSO listarEmpresaxIdPais(Empresa objEmpresa) throws LogicaImplException {
			SSO seguridadAplicaciones = new SSO();

			try {
				List<Empresa> listaEmpresa = factorySeguridadDAO.getEmpresaRepository().findByCodigoPaisPortal(objEmpresa.getCodigoPaisPortal());

				if(listaEmpresa!=null && !listaEmpresa.isEmpty()){
					seguridadAplicaciones.setListaEmpresa(listaEmpresa);
				}else {
					throw new LogicaImplException("No existe lista de Empresa");
				}
			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}

			return seguridadAplicaciones;
		}
		
		public SSO listarTodoEmpresa() throws LogicaImplException {
			SSO seguridadAplicaciones = new SSO();

			try {
				List<Empresa> listaEmpresa = factorySeguridadDAO.getEmpresaRepository().findAll();

				if(listaEmpresa!=null && !listaEmpresa.isEmpty()){
					seguridadAplicaciones.setListaEmpresa(listaEmpresa);
				}else {
					throw new LogicaImplException("No existe lista de Empresa");
				}
			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}

			return seguridadAplicaciones;
		}
		
		/*****************************************************************/
		/********ConfiguracionEmpresaUsuario ConfiguracionEmpresaUsuario**/
		/*****************************************************************/
		public SSO crearConfiguracionEmpresaUsuario(ConfiguracionEmpresaUsuario objConfiguracionEmpresaUsuario) throws LogicaImplException {

			SSO seguridadAplicaciones = new SSO();

			try {

				Pageable pageByEmpresaDesc = PageRequest.of(0, 1, Sort.by("idEmpresa").descending());

				Page<ConfiguracionEmpresaUsuario> pageIdEmpresaDesc = factorySeguridadDAO.getConfiguracionEmpresaUsuarioRepository().findByIdEmpresa(
						objConfiguracionEmpresaUsuario.getIdEmpresa(), pageByEmpresaDesc);

				if(pageIdEmpresaDesc.isEmpty()) {

					Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idConfiguracionEmpresaUsuario").descending());

					Page<ConfiguracionEmpresaUsuario> pageIdConfiguracion = factorySeguridadDAO.getConfiguracionEmpresaUsuarioRepository().findAll(pageByidDesc);

					Integer idConfiguracion = (!pageIdConfiguracion.isEmpty()) ? (Integer) pageIdConfiguracion.getContent().get(0).getIdConfiguracionEmpresaUsuario() +1 : 1; 

					objConfiguracionEmpresaUsuario.setIdConfiguracionEmpresaUsuario(idConfiguracion);

					objConfiguracionEmpresaUsuario.setIdEmpresa(buscarEmpresaxDominio(objConfiguracionEmpresaUsuario.getIdEmpresa()).getEmpresa());

					objConfiguracionEmpresaUsuario.setEstadoConfiguracionEmpresaUsuario(Boolean.parseBoolean(factoryApiProperties.getConfigdata().getEstadoActivoConsulta()));

					factorySeguridadDAO.getConfiguracionEmpresaUsuarioRepository().save(objConfiguracionEmpresaUsuario);

					objConfiguracionEmpresaUsuario  = buscarConfiguracionEmpresaUsuarioxEmpresa(objConfiguracionEmpresaUsuario).getConfiguracionEmpresaUsuario();

					seguridadAplicaciones.setConfiguracionEmpresaUsuario(objConfiguracionEmpresaUsuario);

				}else {
					throw new LogicaImplException("No se puede crear ConfiguracionEmpresaUsuario, empresa ya existe");
				}
			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}

			return seguridadAplicaciones;
		}
		
		public SSO buscarConfiguracionEmpresaUsuarioxEmpresa(ConfiguracionEmpresaUsuario objConfiguracionEmpresaUsuario) throws LogicaImplException {
			SSO seguridadAplicaciones = new SSO();

			try {

				objConfiguracionEmpresaUsuario = factorySeguridadDAO.getConfiguracionEmpresaUsuarioRepository().findByIdEmpresaAndEstadoConfiguracionEmpresaUsuario(
						buscarEmpresa(objConfiguracionEmpresaUsuario.getIdEmpresa()).getEmpresa(), objConfiguracionEmpresaUsuario.getEstadoConfiguracionEmpresaUsuario());

				if(objConfiguracionEmpresaUsuario!=null) {
					seguridadAplicaciones.setConfiguracionEmpresaUsuario(objConfiguracionEmpresaUsuario);
				}

			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}
			return seguridadAplicaciones;
		}
		
		
		/***************************************/
		/********Member Member Member **********/
		/***************************************/
		public SSO crearMember(Member objMember) throws LogicaImplException {
			SSO seguridadAplicaciones = new SSO();

			try {
				Timestamp tsInicial = new Timestamp(new Date().getTime());

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idMember").descending());

				Page<Member> pageIdMember = factorySeguridadDAO.getMemberRepository().findAll(pageByidDesc);

				Integer idMember = (!pageIdMember.isEmpty()) ? (Integer) pageIdMember.getContent().get(0).getIdMember() +1 : 1; 

				objMember.setIdMember(idMember);

				objMember.setIdGenero(buscarGeneroxNombre(objMember.getIdGenero()).getGenero());

				objMember.setCreacionMember(tsInicial);

				factorySeguridadDAO.getMemberRepository().save(objMember);

				objMember  = buscarMember(objMember).getMember();

				seguridadAplicaciones.setMember(objMember);

			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}

			return seguridadAplicaciones;
		}
		
		public SSO buscarMember(Member objMember) throws LogicaImplException {
			
			SSO seguridadAplicaciones = new SSO();

			try {
				//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
				Optional<Member> optPerMember = factorySeguridadDAO.getMemberRepository().findById(objMember.getIdMember());

				/***Si existe reemplazar por el nuevo*/
				if(optPerMember!=null && optPerMember.isPresent()){

					seguridadAplicaciones.setMember(optPerMember.get());

				}else {
					throw new LogicaImplException("No existe Member con identificador:" +objMember.getIdMember());
				}

			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}
			return seguridadAplicaciones;
		}
		
		public SSO listarTodoMember() throws LogicaImplException {
			SSO seguridadAplicaciones = new SSO();

			try {
				List<Member> listaMember = factorySeguridadDAO.getMemberRepository().findAll();

				if(listaMember!=null && !listaMember.isEmpty()){
					seguridadAplicaciones.setListaMember(listaMember);
				}else {
					throw new LogicaImplException("No existe lista de Member");
				}
			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}

			return seguridadAplicaciones;
		}
		
		/***************************************/
		/********Perfil Perfil Perfil **********/
		/***************************************/
	
		public SSO crearPerfil(Perfil objPerfil) throws LogicaImplException {

			SSO seguridadAplicaciones = new SSO();


			try {
				Timestamp tsInicial = new Timestamp(new Date().getTime());

				Pageable pageByUsernameDesc = PageRequest.of(0, 1, Sort.by("usernamePerfil").descending());

				Page<Perfil> pageUsernameDesc  = factorySeguridadDAO.getPerfilRepository().findByUsernamePerfil(
						objPerfil.getUsernamePerfil(), pageByUsernameDesc);

				Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("nombrePerfilLowerCase").descending());

				Page<Perfil> pageNombreDesc  = factorySeguridadDAO.getPerfilRepository().findByNombrePerfilLowerCase(
						objPerfil.getNombrePerfilLowerCase(), pageByNombreDesc);

				Pageable pageByEmailDesc = PageRequest.of(0, 1, Sort.by("emailPerfil").descending());

				Page<Perfil> pageEmailDesc  = factorySeguridadDAO.getPerfilRepository().findByEmailPerfil(
						objPerfil.getEmailPerfil().toLowerCase(), pageByEmailDesc);

				
				if(pageUsernameDesc.isEmpty() && pageNombreDesc.isEmpty() && pageEmailDesc.isEmpty()) {

					Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idPerfil").descending());

					Page<Perfil> pageIdPerfil = factorySeguridadDAO.getPerfilRepository().findAll(pageByidDesc);
					
					Integer idPerfil = (!pageIdPerfil.isEmpty()) ? (Integer) pageIdPerfil.getContent().get(0).getIdPerfil() +1 : 1; 

					objPerfil.setIdPerfil(idPerfil);
					objPerfil.setUltimaAccionUsuario(tsInicial);
					objPerfil.setUltimaConexionPerfil(tsInicial);
					objPerfil.setPasswordUltimaActualizacion(tsInicial);
					objPerfil.setEstadoPerfilLastBloqueado(tsInicial);
					objPerfil.setEstadoUsuarioPerfil(Boolean.parseBoolean(factoryApiProperties.getConfigdata().getEstadoActivoConsulta()));

					factorySeguridadDAO.getPerfilRepository().save(objPerfil);

					objPerfil = buscarPerfilxUsername(objPerfil).getPerfil();

					seguridadAplicaciones.setPerfil(objPerfil);

				}else {
					throw new LogicaImplException("No se puede crear Perfil, parametros ya existen en identificador valido");
				}


			} catch (Exception e) {
				throw new LogicaImplException(e.getMessage());
			}

			return seguridadAplicaciones;
		}
	
	
	public SSO buscarPerfil(Perfil objPerfil) throws LogicaImplException {
		
		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Optional<Perfil> optPerPerfil = factorySeguridadDAO.getPerfilRepository().findById(objPerfil.getIdPerfil());

			/***Si existe reemplazar por el nuevo*/
			if(optPerPerfil!=null && optPerPerfil.isPresent()){

				seguridadAplicaciones.setPerfil(optPerPerfil.get());

			}else {
				throw new LogicaImplException("No existe Perfil con identificador:" +objPerfil.getIdPerfil());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO buscarPerfilxUsernamexPasswordContrasenha(Perfil objPerfil) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByUsernameDesc = PageRequest.of(0, 1, Sort.by("usernamePerfil").descending());

			Page<Perfil> pageUsernameDesc  = factorySeguridadDAO.getPerfilRepository().findByUsernamePerfil(
					objPerfil.getUsernamePerfil(), pageByUsernameDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
			//... solo actualizar estado****/

			Perfil perPerfil  = (!pageUsernameDesc.isEmpty()) ? factorySeguridadDAO.getPerfilRepository().
					findByUsernamePerfilAndPasswordContrasenha(objPerfil.getUsernamePerfil(),  objPerfil.getPasswordContrasenha()) : null;

					if(perPerfil!=null) {
						seguridadAplicaciones.setPerfil(pageUsernameDesc.getContent().get(0));
					}
					else {
						throw new LogicaImplException("No existe Empresa con dominio:" +objPerfil.getUsernamePerfil());
					}
		
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO buscarPerfilxUsername(Perfil objPerfil) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByUsernameDesc = PageRequest.of(0, 1, Sort.by("usernamePerfil").descending());

			Page<Perfil> pageUsernameDesc  = factorySeguridadDAO.getPerfilRepository().findByUsernamePerfil(
					objPerfil.getUsernamePerfil(), pageByUsernameDesc);

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
			//... solo actualizar estado****/
			if(!pageUsernameDesc.isEmpty()){
				seguridadAplicaciones.setPerfil(pageUsernameDesc.getContent().get(0));
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objPerfil.getUsernamePerfil());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO buscarPerfilxUsernameLike(Perfil objPerfil) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {

			List<Perfil> listaPerfil  = factorySeguridadDAO.getPerfilRepository().findByUsernamePerfilLike(objPerfil.getUsernamePerfil());

			/***Busqueda por nombre existe en un tipoNegocio No existe. o solo existe en el pageNombreTipoNegocio.idTipoNegocio = id 
			//... solo actualizar estado****/
			if(listaPerfil!=null && !listaPerfil.isEmpty()){
				seguridadAplicaciones.setListaPerfil(listaPerfil);
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objPerfil.getUsernamePerfil());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}


	public SSO buscarPerfilxEmail(Perfil objPerfil) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByEmailDesc = PageRequest.of(0, 1, Sort.by("emailPerfil").descending());

			Page<Perfil> pageEmailDesc  = factorySeguridadDAO.getPerfilRepository().findByEmailPerfil(
					objPerfil.getUsernamePerfil(), pageByEmailDesc);
			
			if(!pageEmailDesc.isEmpty()){
				seguridadAplicaciones.setPerfil(pageEmailDesc.getContent().get(0));
			}
			else {
				throw new LogicaImplException("No existe Empresa con dominio:" +objPerfil.getUsernamePerfil());
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}


//	public Perfil buscarPerfilxOnlyUsernamePerfilModel(Perfil objPerfil) throws LogicaImplException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//	public Perfil buscarPerfilxOnlyNombreUsuarioPerfilModel(Perfil objPerfil) throws LogicaImplException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	public SSO listarTodoPerfil() throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			List<Perfil> listaPerfil = factorySeguridadDAO.getPerfilRepository().findAll();

			if(listaPerfil!=null && !listaPerfil.isEmpty()){
				seguridadAplicaciones.setListaPerfil(listaPerfil);
			}else {
				throw new LogicaImplException("No existe lista de Perfil");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	/********************************************/
	/********Usuario Usuario Usuario ************/
	/********************************************/
	
	public SSO generarCodigoUsuario(Usuario objUsuario) throws LogicaImplException{

		SSO seguridadAplicaciones = new SSO();

		try {

			buscarMember(objUsuario.getIdMember());

			buscarPerfilxUsername(objUsuario.getIdPerfil());

			String codigoViaje = zapalaClienteRest.generarCodigoByNumero(new ZapalaRequest(
					SSOUtilidades.crearListaCadenaCodigoUsuario(objUsuario))).getCodigoGenerado();  

			/**Buscar si el codigo existe*/
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("codigoUsuarioUnit").descending());

			Page<Usuario> pageCodigoDesc  = factorySeguridadDAO.getUsuarioRepository().findByCodigoUsuarioUnit(
					objUsuario.getCodigoUsuarioUnit(), pageByNombreDesc);

			if(pageCodigoDesc.isEmpty()) {

				objUsuario.setCodigoUsuarioUnit(codigoViaje);

				seguridadAplicaciones.setUsuario(objUsuario);

			}else {
				throw new LogicaImplException("No se puede crear codigo de viaje, datos de validacion erroneos");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	public SSO crearUsuario(Usuario objUsuario) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();


		try {

			Usuario metUsuario = factorySeguridadDAO.getUsuarioRepository().findByIdMemberAndIdPerfil(objUsuario.getIdMember() , objUsuario.getIdPerfil());

			if(metUsuario==null) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idUsuario").descending());

				Page<Usuario> pageIdUsuario = factorySeguridadDAO.getUsuarioRepository().findAll(pageByidDesc);

				Integer idUsuario = (!pageIdUsuario.isEmpty()) ? (Integer) pageIdUsuario.getContent().get(0).getIdUsuario() +1 : 1; 

				objUsuario.setIdUsuario(idUsuario);
				
				objUsuario.setIdMember(buscarMember(objUsuario.getIdMember()).getMember());
				
				objUsuario.setIdPerfil(buscarPerfilxUsername(objUsuario.getIdPerfil()).getPerfil());

				factorySeguridadDAO.getUsuarioRepository().save(objUsuario);

				objUsuario = buscarUsuarioxCodigo(objUsuario).getUsuario();

				seguridadAplicaciones.setUsuario(objUsuario);

			}else {
				throw new LogicaImplException("No se puede crear Perfil, parametros ya existen en identificador valido");
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	public SSO buscarUsuarioxCodigo(Usuario objUsuario) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.
			Pageable pageByNombreDesc = PageRequest.of(0, 1, Sort.by("codigoUsuarioUnit").descending());

			Page<Usuario> pageCodigoDesc  = factorySeguridadDAO.getUsuarioRepository().findByCodigoUsuarioUnit(
					objUsuario.getCodigoUsuarioUnit(), pageByNombreDesc);
			
			if(!pageCodigoDesc.isEmpty()){
				seguridadAplicaciones.setUsuario(pageCodigoDesc.getContent().get(0));
			}
			else {
				throw new LogicaImplException("No existe Usuario con codigo:" +objUsuario.getCodigoUsuarioUnit());
			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO listarTodoUsuario() throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			List<Usuario> listaUsuario = factorySeguridadDAO.getUsuarioRepository().findAll();

			if(listaUsuario!=null && !listaUsuario.isEmpty()){
				seguridadAplicaciones.setListaUsuario(listaUsuario);
			}else {
				throw new LogicaImplException("No existe lista de Usuario");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	/****************************************************/
	/********AplicacionRol AplicacionRol AplicacionRol***/
	/****************************************************/
	public SSO crearAplicacionRol(AplicacionRol objAplicacionRol) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {
			
			AplicacionRol metAplicacionRol = factorySeguridadDAO.getAplicacionRolRepository().findByIdAplicacionAndIdRol(buscarAplicacionxUriRuta(objAplicacionRol.getIdAplicacion()).getAplicacion(), buscarRolxNombre(objAplicacionRol.getIdRol()).getRol());

			if(metAplicacionRol==null) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idAplicacionRol").descending());

				Page<AplicacionRol> pageIdAplicacionRol = factorySeguridadDAO.getAplicacionRolRepository().findAll(pageByidDesc);

				Integer idAplicacionRol = (!pageIdAplicacionRol.isEmpty()) ? (Integer) pageIdAplicacionRol.getContent().get(0).getIdAplicacionRol() +1 : 1; 

				objAplicacionRol.setIdAplicacionRol(idAplicacionRol);

				objAplicacionRol.setEstadoAplicacionRol(Boolean.parseBoolean(factoryApiProperties.getConfigdata().getEstadoActivoConsulta()));

				factorySeguridadDAO.getAplicacionRolRepository().save(objAplicacionRol);

				objAplicacionRol = buscarAplicacionRolxAplicacionxRol(objAplicacionRol).getAplicacionRol();

				seguridadAplicaciones.setAplicacionRol(objAplicacionRol);

			}else {
				throw new LogicaImplException("No se puede crear AplicacionRol, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	

	public SSO buscarAplicacionRolxAplicacionxRol(AplicacionRol objAplicacionRol)
			throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			objAplicacionRol = factorySeguridadDAO.getAplicacionRolRepository().findByIdAplicacionAndIdRol(objAplicacionRol.getIdAplicacion(), objAplicacionRol.getIdRol());

			if(objAplicacionRol.getEstadoAplicacionRol()) {
				seguridadAplicaciones.setAplicacionRol(objAplicacionRol);
			}
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}

	/****************************************************/
	/********Identificador Identificador Identificador***/
	/****************************************************/
	
	public SSO crearIdentificador(Identificador objIdentificador) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {

			Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idIdentificador").descending());

			Page<Identificador> pageIdIdentificador = factorySeguridadDAO.getIdentificadorRepository().findAll(pageByidDesc);

			Integer idIdentificador = (!pageIdIdentificador.isEmpty()) ? (Integer) pageIdIdentificador.getContent().get(0).getIdIdentificador() +1 : 1;

			objIdentificador.setIdIdentificador(idIdentificador);

			objIdentificador.setIdMember(buscarMember(objIdentificador.getIdMember()).getMember());

			factorySeguridadDAO.getIdentificadorRepository().save(objIdentificador);

			objIdentificador  = buscarIdentificadorxValuexPais(objIdentificador).getIdentificador();

			seguridadAplicaciones.setIdentificador(objIdentificador);

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}


	public SSO buscarIdentificadorxValuexPais(Identificador objIdentificador) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			objIdentificador = factorySeguridadDAO.getIdentificadorRepository().findByValueIdentificadorAndNombreIdentificadorAndCodigoPaisPortal
					(objIdentificador.getValueIdentificador(), objIdentificador.getNombreIdentificador(), objIdentificador.getCodigoPaisPortal());

			if(objIdentificador!=null && objIdentificador.getIdIdentificador()>0) {
				/**Enviar Formateado el RUT*/
//				objIdentificador.setValueIdentificador(sssoUtilidadImpl.generarPatronRUT(objIdentificador.getValueIdentificador()));
				
				seguridadAplicaciones.setIdentificador(objIdentificador);
			}
			else {
				throw new LogicaImplException("No existe Identificador con value:" +objIdentificador.getValueIdentificador()+"- y nombre:"+objIdentificador.getNombreIdentificador());
			}
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	/****************************************************/
	/********AccionPerfil AccionPerfil AccionPerfil *****/
	/****************************************************/
	public SSO crearFotoPerfil(FotoPerfil objFotoPerfil) throws LogicaImplException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/****************************************************/
	/********AccionPerfil AccionPerfil AccionPerfil *****/
	/****************************************************/
	
	public SSO crearAccionPerfil(AccionPerfil objAccionPerfil)  throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {
			Timestamp tsInicial = new Timestamp(new Date().getTime());
			
			buscarPerfilxUsername(objAccionPerfil.getIdPerfil());

			buscarTipoAccionPerfil(objAccionPerfil.getIdTipoAccionPerfil());

			Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idAccionPerfil").descending());

			Page<AccionPerfil> pageIdAccionPerfil = factorySeguridadDAO.getAccionPerfilRepository().findAll(pageByidDesc);

			Integer idAccionPerfil = (!pageIdAccionPerfil.isEmpty()) ? (Integer) pageIdAccionPerfil.getContent().get(0).getIdAccionPerfil() +1 : 1;

			objAccionPerfil.setIdAccionPerfil(idAccionPerfil);

			objAccionPerfil.setIdTipoAccionPerfil(buscarTipoAccionPerfil(objAccionPerfil.getIdTipoAccionPerfil()).getTipoAccionPerfil());

			objAccionPerfil.setIdPerfil(buscarPerfilxUsername(objAccionPerfil.getIdPerfil()).getPerfil());
			
			objAccionPerfil.setUltimaAccionPerfil(tsInicial);
			
			factorySeguridadDAO.getAccionPerfilRepository().save(objAccionPerfil);

			objAccionPerfil  = buscarAccionPerfilxPerfilxTipoAccionxKeyAccion(objAccionPerfil).getAccionPerfil();

			seguridadAplicaciones.setAccionPerfil(objAccionPerfil);

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	public SSO buscarAccionPerfilxPerfilxTipoAccionxKeyAccion(AccionPerfil objAccionPerfil)
			throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {
			objAccionPerfil = factorySeguridadDAO.getAccionPerfilRepository().findByidPerfilAndIdTipoAccionPerfilAndKeyAccionPerfil
					(objAccionPerfil.getIdPerfil(), objAccionPerfil.getIdTipoAccionPerfil(), objAccionPerfil.getKeyAccionPerfil());

			if(objAccionPerfil.getIdAccionPerfil()>0) {
				seguridadAplicaciones.setAccionPerfil(objAccionPerfil);
			}
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	/*******************************************************/
	/********MaquinaEmpresa MaquinaEmpresa MaquinaEmpresa***/
	/*******************************************************/
	public SSO crearMaquinaEmpresa(MaquinaEmpresa objMaquinaEmpresa) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {

			buscarEmpresa(objMaquinaEmpresa.getIdEmpresa());

			buscarMaquinaxDireccionIpMaquina(objMaquinaEmpresa.getIdMaquina());

			MaquinaEmpresa metMaquinaEmpresa = factorySeguridadDAO.getMaquinaEmpresaRepository().findByIdMaquinaAndIdEmpresa(objMaquinaEmpresa.getIdMaquina(), objMaquinaEmpresa.getIdEmpresa());

			if(metMaquinaEmpresa==null) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idMaquinaEmpresa").descending());

				Page<MaquinaEmpresa> pageIdMaquinaEmpresa = factorySeguridadDAO.getMaquinaEmpresaRepository().findAll(pageByidDesc);

				Integer idMaquinaEmpresa = (!pageIdMaquinaEmpresa.isEmpty()) ? (Integer) pageIdMaquinaEmpresa.getContent().get(0).getIdMaquinaEmpresa() +1 : 1;

				objMaquinaEmpresa.setIdMaquinaEmpresa(idMaquinaEmpresa);

				objMaquinaEmpresa.setIdEmpresa(buscarEmpresa(objMaquinaEmpresa.getIdEmpresa()).getEmpresa());

				objMaquinaEmpresa.setIdMaquina(buscarMaquinaxDireccionIpMaquina(objMaquinaEmpresa.getIdMaquina()).getMaquina());

				factorySeguridadDAO.getMaquinaEmpresaRepository().save(objMaquinaEmpresa);

				seguridadAplicaciones.setMaquinaEmpresa(objMaquinaEmpresa);
			}else {
				throw new LogicaImplException("No existe MaquinaEmpresa con maquina:" +objMaquinaEmpresa.getIdMaquina()+"- y empresa:"+objMaquinaEmpresa.getIdEmpresa());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}

	public SSO listarMaquinaEmpresaxEmpresa(MaquinaEmpresa objMaquinaEmpresa)
			throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {

			buscarEmpresa(objMaquinaEmpresa.getIdEmpresa());

			List<MaquinaEmpresa> listaMaquinaEmpresa = factorySeguridadDAO.getMaquinaEmpresaRepository().findByIdEmpresa(objMaquinaEmpresa.getIdEmpresa());

			if(listaMaquinaEmpresa!=null && !listaMaquinaEmpresa.isEmpty()) {
				seguridadAplicaciones.setListaMaquinaEmpresa(listaMaquinaEmpresa);
			}
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}

	/*****************************************************************/
	/********AplicacionEmpresa AplicacionEmpresa AplicacionEmpresa ***/
	/*****************************************************************/
	public SSO crearAplicacionEmpresa(AplicacionEmpresa objAplicacionEmpresa)
			throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {
			buscarEmpresaxNombre(objAplicacionEmpresa.getIdEmpresa()).getEmpresa();

			buscarAplicacionxUriRuta(objAplicacionEmpresa.getIdAplicacion()).getAplicacion();
			
			AplicacionEmpresa metAplicacionEmpresa = factorySeguridadDAO.getAplicacionEmpresaRepository().findByIdAplicacionAndIdEmpresa(objAplicacionEmpresa.getIdAplicacion(), objAplicacionEmpresa.getIdEmpresa());
			
			if(metAplicacionEmpresa==null) {
				
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idAplicacionEmpresa").descending());

				Page<AplicacionEmpresa> pageIdAplicacionEmpresa = factorySeguridadDAO.getAplicacionEmpresaRepository().findAll(pageByidDesc);

				Integer idAplicacionEmpresa = (!pageIdAplicacionEmpresa.isEmpty()) ? (Integer) pageIdAplicacionEmpresa.getContent().get(0).getIdAplicacionEmpresa() +1 : 1;

				objAplicacionEmpresa.setIdAplicacionEmpresa(idAplicacionEmpresa);

				objAplicacionEmpresa.setEstadoAplicacionEmpresa(Boolean.parseBoolean(factoryApiProperties.getConfigdata().getEstadoActivoConsulta()));

				factorySeguridadDAO.getAplicacionEmpresaRepository().save(objAplicacionEmpresa);

				objAplicacionEmpresa = buscarAplicacionEmpresaxAplicacionxEmpresa(objAplicacionEmpresa).getAplicacionEmpresa();

				seguridadAplicaciones.setAplicacionEmpresa(objAplicacionEmpresa);

			}else {
				throw new LogicaImplException("No se puede crear AplicacionEmpresa, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	public SSO buscarAplicacionEmpresaxAplicacionxEmpresa(AplicacionEmpresa objAplicacionEmpresa) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {

			objAplicacionEmpresa = factorySeguridadDAO.getAplicacionEmpresaRepository().findByIdAplicacionAndIdEmpresa(
					objAplicacionEmpresa.getIdAplicacion(), objAplicacionEmpresa.getIdEmpresa());

			if(objAplicacionEmpresa != null && objAplicacionEmpresa.getIdAplicacionEmpresa() != null) {
				seguridadAplicaciones.setAplicacionEmpresa(objAplicacionEmpresa);
			}
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO listarAplicacionEmpresaxEmpresa(AplicacionEmpresa objAplicacionEmpresa)
			throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {

			List<AplicacionEmpresa> listaAplicacionEmpresa = factorySeguridadDAO.getAplicacionEmpresaRepository().
					findByIdEmpresa(objAplicacionEmpresa.getIdEmpresa());

			if(listaAplicacionEmpresa!=null && !listaAplicacionEmpresa.isEmpty()) {
				seguridadAplicaciones.setListaAplicacionEmpresa(listaAplicacionEmpresa);
			}
			//Como la lista es pequeña, obtener todos desde cache y luego buscar el Id.

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}

	/*****************************************************************/
	/********EmpresaUsuario EmpresaUsuario EmpresaUsuario ************/
	/*****************************************************************/
	
	public SSO crearEmpresaUsuario(EmpresaUsuario objEmpresaUsuario) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {
			
			EmpresaUsuario metEmpresaUsuario = factorySeguridadDAO.getEmpresaUsuarioRepository().findByIdEmpresaAndIdUsuarioAndIdRol(
					buscarEmpresaxNombre(objEmpresaUsuario.getIdEmpresa()).getEmpresa(), buscarUsuarioxCodigo(objEmpresaUsuario.getIdUsuario()).getUsuario(), buscarRolxNombre(objEmpresaUsuario.getIdRol()).getRol());

			if(metEmpresaUsuario==null) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idEmpresaUsuario").descending());

				Page<EmpresaUsuario> pageIdEmpresaUsuario = factorySeguridadDAO.getEmpresaUsuarioRepository().findAll(pageByidDesc);

				Integer idEmpresaUsuario = (!pageIdEmpresaUsuario.isEmpty()) ? (Integer) pageIdEmpresaUsuario.getContent().get(0).getIdEmpresaUsuario() +1 : 1;

				objEmpresaUsuario.setIdEmpresaUsuario(idEmpresaUsuario);

				objEmpresaUsuario.setEstadoEmpresaUsuario(Boolean.parseBoolean(factoryApiProperties.getConfigdata().getEstadoActivoConsulta()));

				factorySeguridadDAO.getEmpresaUsuarioRepository().save(objEmpresaUsuario);

				objEmpresaUsuario = buscarEmpresaUsuarioxEmpresaxUsuarioxRol(objEmpresaUsuario).getEmpresaUsuario();

				seguridadAplicaciones.setEmpresaUsuario(objEmpresaUsuario);

			}else {
				throw new LogicaImplException("No se puede crear Perfil, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	public SSO buscarEmpresaUsuario(EmpresaUsuario objEmpresaUsuario) throws LogicaImplException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**Id, Id, Id****/
	public SSO buscarEmpresaUsuarioxEmpresaxUsuarioxRol(EmpresaUsuario objEmpresaUsuario) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {

			buscarEmpresaxNombre(objEmpresaUsuario.getIdEmpresa()).getEmpresa();

			buscarUsuarioxCodigo(objEmpresaUsuario.getIdUsuario()).getUsuario();

			buscarRolxNombre(objEmpresaUsuario.getIdRol()).getRol();

			objEmpresaUsuario = factorySeguridadDAO.getEmpresaUsuarioRepository().findByIdEmpresaAndIdUsuarioAndIdRol(
					objEmpresaUsuario.getIdEmpresa(), objEmpresaUsuario.getIdUsuario(), objEmpresaUsuario.getIdRol());

			if(objEmpresaUsuario!=null) {
				seguridadAplicaciones.setEmpresaUsuario(objEmpresaUsuario);
			}else {
				throw new LogicaImplException("No existe EmpresaUsuario con estos parametros:");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO listarEmpresaUsuarioxEmpresa(EmpresaUsuario objEmpresaUsuario)  throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {

			buscarEmpresa(objEmpresaUsuario.getIdEmpresa());

			List<EmpresaUsuario> listaEmpresaUsuario = factorySeguridadDAO.getEmpresaUsuarioRepository().findByIdEmpresa(
					objEmpresaUsuario.getIdEmpresa());

			if(listaEmpresaUsuario!=null && !listaEmpresaUsuario.isEmpty()) {
				seguridadAplicaciones.setListaEmpresaUsuario(listaEmpresaUsuario);
			}else {
				throw new LogicaImplException("No existe EmpresaUsuario con estos parametros:");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO listarEmpresaUsuarioxEmpresaxRol(EmpresaUsuario objEmpresaUsuario)  throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {

			buscarEmpresa(objEmpresaUsuario.getIdEmpresa()).getEmpresa();

			buscarRolxNombre(objEmpresaUsuario.getIdRol()).getRol();

			objEmpresaUsuario = factorySeguridadDAO.getEmpresaUsuarioRepository().findByIdEmpresaAndIdUsuarioAndIdRol(
					objEmpresaUsuario.getIdEmpresa(), objEmpresaUsuario.getIdUsuario(), objEmpresaUsuario.getIdRol());

			if(objEmpresaUsuario!=null) {
				seguridadAplicaciones.setEmpresaUsuario(objEmpresaUsuario);
			}else {
				throw new LogicaImplException("No existe EmpresaUsuario con estos parametros:");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	/*****************************************************************/
	/********AplicacionServicio AplicacionServicio AplicacionServicio*/
	/*****************************************************************/
	public SSO crearAplicacionServicio(AplicacionServicio objAplicacionServicio)
			throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {

			AplicacionServicio metAplicacionServicio = factorySeguridadDAO.getAplicacionServicioRepository().findByIdAplicacionAndUriRutaAplicacionAndUriRutaAplicacionProductoAndUriRutaAplicacionProductoServicioAndMetodoHttp(
					buscarAplicacionxUriRuta(objAplicacionServicio.getIdAplicacion()).getAplicacion(),
					objAplicacionServicio.getUriRutaAplicacion(), objAplicacionServicio.getUriRutaAplicacionProducto(),
					objAplicacionServicio.getUriRutaAplicacionProductoServicio(), objAplicacionServicio.getMetodoHttp());

			if(metAplicacionServicio == null) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idAplicacionServicio").descending());

				Page<AplicacionServicio> pageIdAplicacionServicio = factorySeguridadDAO.getAplicacionServicioRepository().findAll(pageByidDesc);

				Integer idAplicacionServicio = (!pageIdAplicacionServicio.isEmpty()) ? (Integer) pageIdAplicacionServicio.getContent().get(0).getIdAplicacionServicio() +1 : 1;

				objAplicacionServicio.setIdAplicacionServicio(idAplicacionServicio);

				objAplicacionServicio.setEstadoAplicacionServicio(Boolean.parseBoolean(factoryApiProperties.getConfigdata().getEstadoActivoConsulta()));

				factorySeguridadDAO.getAplicacionServicioRepository().save(objAplicacionServicio);

				objAplicacionServicio = buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(objAplicacionServicio).getAplicacionServicio();

				seguridadAplicaciones.setAplicacionServicio(objAplicacionServicio);
			}else {
				throw new LogicaImplException("No se puede crear AplicacionServicio, parametros ya existen en identificador valido");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	public SSO buscarAplicacionServicio(AplicacionServicio objAplicacionServicio)
			throws LogicaImplException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public SSO buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp( AplicacionServicio objAplicacionServicio) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {

			buscarAplicacionxUriRuta(objAplicacionServicio.getIdAplicacion()).getAplicacion();

			objAplicacionServicio = factorySeguridadDAO.getAplicacionServicioRepository().
					findByIdAplicacionAndUriRutaAplicacionAndUriRutaAplicacionProductoAndUriRutaAplicacionProductoServicioAndMetodoHttp(
							objAplicacionServicio.getIdAplicacion(), objAplicacionServicio.getUriRutaAplicacion(), 
							objAplicacionServicio.getUriRutaAplicacionProducto(),
							objAplicacionServicio.getUriRutaAplicacionProductoServicio(), objAplicacionServicio.getMetodoHttp());

			if(objAplicacionServicio!=null) {

				seguridadAplicaciones.setAplicacionServicio(objAplicacionServicio);

			}else {
				throw new LogicaImplException("No existe EmpresaUsuario con estos parametros:");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}


	public SSO listarAplicacionServicioxAplicacion(AplicacionServicio objAplicacionServicio) throws LogicaImplException {

		SSO seguridadAplicaciones = new SSO();

		try {

			buscarAplicacionxUriRuta(objAplicacionServicio.getIdAplicacion()).getAplicacion();

			List<AplicacionServicio> listaAplicacionServicio = factorySeguridadDAO.getAplicacionServicioRepository().
					findByIdAplicacion(objAplicacionServicio.getIdAplicacion());

			if(listaAplicacionServicio!=null && !listaAplicacionServicio.isEmpty()) {

				seguridadAplicaciones.setListaAplicacionServicio(listaAplicacionServicio);

			}else {

				throw new LogicaImplException("No existe EmpresaUsuario con estos parametros:");

			}


		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	public SSO listarTodoAplicacionServicio() throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {
			List<AplicacionServicio> listaAplicacionServicio = factorySeguridadDAO.getAplicacionServicioRepository().findAll();

			if(listaAplicacionServicio!=null && !listaAplicacionServicio.isEmpty()){
				seguridadAplicaciones.setListaAplicacionServicio(listaAplicacionServicio);
			}else {
				throw new LogicaImplException("No existe lista de Empresa");
			}
		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}

	
	/****************************************************************************/
	/********EmpresaUsuarioAplicacionEmpresa EmpresaUsuarioAplicacionEmpresa ****/
	/****************************************************************************/
	
	public SSO crearEmpresaUsuarioAplicacionEmpresa(EmpresaUsuarioAplicacionEmpresa objEUAE)
			throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();


		try {

			EmpresaUsuarioAplicacionEmpresa metEUAE = factorySeguridadDAO.getEmpresaUsuarioAplicacionEmpresaRepository().
					findByIdEmpresaUsuarioAndIdAplicacionEmpresa(buscarEmpresaUsuarioxEmpresaxUsuarioxRol(objEUAE.getIdEmpresaUsuario()).getEmpresaUsuario(), 
							buscarAplicacionEmpresaxAplicacionxEmpresa(objEUAE.getIdAplicacionEmpresa()).getAplicacionEmpresa());

			if(metEUAE==null) {

				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idEmpresaUsuarioAplicacionEmpresa").descending());

				Page<EmpresaUsuarioAplicacionEmpresa> pageIdEUAE = factorySeguridadDAO.getEmpresaUsuarioAplicacionEmpresaRepository().findAll(pageByidDesc);

				Integer idEUAE = (!pageIdEUAE.isEmpty()) ? (Integer) pageIdEUAE.getContent().get(0).getIdEmpresaUsuarioAplicacionEmpresa() +1 : 1;

				objEUAE.setIdEmpresaUsuarioAplicacionEmpresa(idEUAE);

				objEUAE.setEstadoEmpresaUsuarioAplicacionEmpresa(Boolean.parseBoolean(factoryApiProperties.getConfigdata().getEstadoActivoConsulta()));

				factorySeguridadDAO.getEmpresaUsuarioAplicacionEmpresaRepository().save(objEUAE);

				objEUAE = buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(objEUAE).getEmpresaUsuarioAplicacionEmpresa();

				seguridadAplicaciones.setEmpresaUsuarioAplicacionEmpresa(objEUAE);

			}else {
				throw new LogicaImplException("No se puede crear EUAE, Aplicacion no existe");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	public SSO buscarEmpresaUsuarioAplicacionEmpresa(EmpresaUsuarioAplicacionEmpresa objEUAE)
			throws LogicaImplException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public SSO buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(EmpresaUsuarioAplicacionEmpresa objEUAE) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {

			objEUAE = factorySeguridadDAO.getEmpresaUsuarioAplicacionEmpresaRepository().findByIdEmpresaUsuarioAndIdAplicacionEmpresa(
					buscarEmpresaUsuarioxEmpresaxUsuarioxRol(objEUAE.getIdEmpresaUsuario()).getEmpresaUsuario(), buscarAplicacionEmpresaxAplicacionxEmpresa(objEUAE.getIdAplicacionEmpresa()).getAplicacionEmpresa());

			if(objEUAE != null) {
				seguridadAplicaciones.setEmpresaUsuarioAplicacionEmpresa(objEUAE);
			}else {
				throw new LogicaImplException("No existe EmpresaUsuarioAplicacionEmpresa con estos parametros:");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	
	public SSO listarEmpresaUsuarioAplicacionEmpresaxEU(EmpresaUsuarioAplicacionEmpresa objEUAE)
			throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {

			List<EmpresaUsuarioAplicacionEmpresa> listaEmpresaUsuarioAplicacionEmpresa = factorySeguridadDAO.getEmpresaUsuarioAplicacionEmpresaRepository().
					findByIdEmpresaUsuario(buscarEmpresaUsuarioxEmpresaxUsuarioxRol(objEUAE.getIdEmpresaUsuario()).getEmpresaUsuario());

			if(listaEmpresaUsuarioAplicacionEmpresa!=null && !listaEmpresaUsuarioAplicacionEmpresa.isEmpty()) {

				seguridadAplicaciones.setListaEmpresaUsuarioAplicacionEmpresa(listaEmpresaUsuarioAplicacionEmpresa);

			}else {
				throw new LogicaImplException("No existe EmpresaUsuario con estos parametros:");
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}
	
	/****************************************************************************/
	/********EmpresaUsuarioAplicacionEmpresa EmpresaUsuarioAplicacionEmpresa ****/
	/****************************************************************************/
	
	public SSO crearSeguridadAplicacionAcceso(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso)
			throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();


		try {

			SeguridadAplicacionAcceso metSAA = factorySeguridadDAO.getSeguridadAplicacionAccesoRepository().findByIdEmpresaUsuarioAplicacionEmpresaAndIdAplicacionServicio(
					buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(objSeguridadAplicacionAcceso.getIdEmpresaUsuarioAplicacionEmpresa()).getEmpresaUsuarioAplicacionEmpresa(),
					buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(objSeguridadAplicacionAcceso.getIdAplicacionServicio()).getAplicacionServicio());
			
			if(metSAA == null) {
				Pageable pageByidDesc = PageRequest.of(0, 1, Sort.by("idSeguridadAplicacionAcceso").descending());

				Page<SeguridadAplicacionAcceso> pageIdSAA = factorySeguridadDAO.getSeguridadAplicacionAccesoRepository().findAll(pageByidDesc);

				Integer idSeguridadAplicacionAcceso = (!pageIdSAA.isEmpty()) ? (Integer) pageIdSAA.getContent().get(0).getIdSeguridadAplicacionAcceso() +1 : 1;

				objSeguridadAplicacionAcceso.setIdSeguridadAplicacionAcceso(idSeguridadAplicacionAcceso);

				objSeguridadAplicacionAcceso.setEstadoSeguridadAplicacionAcceso(Boolean.parseBoolean(factoryApiProperties.getConfigdata().getEstadoActivoConsulta()));

				factorySeguridadDAO.getSeguridadAplicacionAccesoRepository().save(objSeguridadAplicacionAcceso);

				seguridadAplicaciones.setSeguridadAplicacionAcceso(objSeguridadAplicacionAcceso);
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}

		return seguridadAplicaciones;
	}
	
	public SSO listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso) throws LogicaImplException {
		SSO seguridadAplicaciones = new SSO();

		try {

			EmpresaUsuarioAplicacionEmpresa seguridadAplicacionesEmpresaUsuarioAplicacionEmpresa 
				= buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(objSeguridadAplicacionAcceso.getIdEmpresaUsuarioAplicacionEmpresa()).getEmpresaUsuarioAplicacionEmpresa();

			if(seguridadAplicacionesEmpresaUsuarioAplicacionEmpresa!=null && seguridadAplicacionesEmpresaUsuarioAplicacionEmpresa.getIdEmpresaUsuarioAplicacionEmpresa()!=null 
					&& seguridadAplicacionesEmpresaUsuarioAplicacionEmpresa.getIdEmpresaUsuarioAplicacionEmpresa()>0) {
				
				AplicacionServicio seguridadAplicacionesAplicacionServicio = 
						buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(objSeguridadAplicacionAcceso.getIdAplicacionServicio()).
							getAplicacionServicio();

				if(seguridadAplicacionesAplicacionServicio!=null && seguridadAplicacionesAplicacionServicio.getIdAplicacionServicio()!=null && seguridadAplicacionesAplicacionServicio.getIdAplicacionServicio()>0) {
					
					List<SeguridadAplicacionAcceso> listaSeguridadAplicacionAcceso = null;
//					List<SeguridadAplicacionAcceso> listaSeguridadAplicacionAcceso = factorySeguridadDAO.getSeguridadAplicacionAccesoRepository().
//							findByIdEmpresaUsuarioAplicacionEmpresaAndIdAplicacionServicioInAndEstadoSeguridadAplicacionAcceso
//							(objSeguridadAplicacionAcceso.getIdEmpresaUsuarioAplicacionEmpresa(), 
//									objSeguridadAplicacionAcceso.getIdAplicacionServicio(), 
//									objSeguridadAplicacionAcceso.getEstadoSeguridadAplicacionAcceso());

						if(listaSeguridadAplicacionAcceso!=null && !listaSeguridadAplicacionAcceso.isEmpty()) {
							seguridadAplicaciones.setListaSeguridadAplicacionAcceso(listaSeguridadAplicacionAcceso);
						}else {
							throw new LogicaImplException("No existe SeguridadAplicacionAcceso con estos parametros:");
						}
					
				}else {
					throw new LogicaImplException("No existe SeguridadAplicacionAcceso usuario:"+objSeguridadAplicacionAcceso.getIdAplicacionServicio());
				}
			}else {
				throw new LogicaImplException("No existe SeguridadAplicacionAcceso empresa:"+objSeguridadAplicacionAcceso.getIdEmpresaUsuarioAplicacionEmpresa());
			}

		} catch (Exception e) {
			throw new LogicaImplException(e.getMessage());
		}
		return seguridadAplicaciones;
	}

	public SSO buscarSeguridadAplicacionAcceso(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso)
			throws LogicaImplException {
		// TODO Auto-generated method stub
		return null;
	}

	


	

	

}
