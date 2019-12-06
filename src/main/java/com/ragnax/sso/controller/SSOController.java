package com.ragnax.sso.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;

import com.ragnax.sso.controller.response.RagnaxError;
import com.ragnax.sso.entidad.AccionPerfil;
import com.ragnax.sso.entidad.Aplicacion;
import com.ragnax.sso.entidad.AplicacionEmpresa;
import com.ragnax.sso.entidad.AplicacionRol;
import com.ragnax.sso.entidad.AplicacionServicio;
import com.ragnax.sso.entidad.ConfiguracionEmpresaUsuario;
import com.ragnax.sso.entidad.Empresa;
import com.ragnax.sso.entidad.EmpresaUsuario;
import com.ragnax.sso.entidad.EmpresaUsuarioAplicacionEmpresa;
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
import com.ragnax.sso.servicio.SSOService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@RequestMapping
public class SSOController {

	@Autowired
	SSOService factorySSSOService;
	
	/***************************************************/
	/*************** Rol  ******************************/
	/***************************************************/
	@ApiOperation(value = "buscarRolxNombre", response = Rol.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Rol.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarRolxNombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rol>  buscarRolxNombre(@ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Rol objRol, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarRolxNombre(objRol).getRol(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarAplicacionxUriRuta", response = Aplicacion.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Aplicacion.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarAplicacionxUriRuta}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Aplicacion>  buscarAplicacionxUriRuta(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Aplicacion objAplicacion, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarAplicacionxUriRuta(objAplicacion).getAplicacion(),
				HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarMaquinaxDireccionIpMaquina", response = Maquina.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Maquina.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarMaquinaxDireccionIpMaquina}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Maquina>  buscarMaquinaxDireccionIpMaquina(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Maquina objMaquina, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarMaquinaxDireccionIpMaquina(
				objMaquina).getMaquina(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarEmpresa", response = Empresa.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Empresa.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa>  buscarEmpresa(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Empresa objEmpresa, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarEmpresa(
				objEmpresa).getEmpresa(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarEmpresaxDominio", response = Empresa.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Empresa.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarEmpresaxDominio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Empresa>  buscarEmpresaxDominio(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Empresa objEmpresa, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarEmpresaxDominio(
				objEmpresa).getEmpresa(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarPerfilxUsername", response = Perfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Perfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarPerfilxUsername}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Perfil>  buscarPerfilxUsername(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Perfil objPerfil, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarPerfilxUsername(objPerfil).getPerfil() ,HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarPerfilxUsernamexPasswordContrasenha", response = Perfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Perfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarPerfilxUsernamexPasswordContrasenha}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Perfil>  buscarPerfilxUsernamexPasswordContrasenha(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Perfil objPerfil, @ApiIgnore Errors errors)  throws LogicaImplException{

		

		return new ResponseEntity<>(factorySSSOService.buscarPerfilxUsernamexPasswordContrasenha(
				objPerfil).getPerfil(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarPerfilxEmail", response = Perfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Perfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarPerfilxEmail}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Perfil>  buscarPerfilxEmail(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Perfil objPerfil, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarPerfilxEmail(objPerfil).getPerfil(), HttpStatus.OK);
	}
	
//	Seguridad buscarPerfilxOnlyUsernamePerfilModel(Perfil objPerfil) throws LogicaImplException;
//	
//	Seguridad buscarPerfilxOnlyNombreUsuarioPerfilModel(Perfil objPerfil) throws LogicaImplException;
	
	@ApiOperation(value = "buscarGeneroxNombre", response = Genero.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Genero.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarGeneroxNombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Genero>  buscarGeneroxNombre(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Genero objGenero, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarGeneroxNombre(objGenero).getGenero(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarTipoAccionPerfil", response = TipoAccionPerfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoAccionPerfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarTipoAccionPerfil}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoAccionPerfil>  buscarTipoAccionPerfil(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid TipoAccionPerfil objTipoAccionPerfil, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarTipoAccionPerfil(objTipoAccionPerfil).getTipoAccionPerfil(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "listarTipoAccionPerfil", response = TipoAccionPerfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = TipoAccionPerfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.listarTipoAccionPerfil}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TipoAccionPerfil>> listarTipoAccionPerfil(  @ApiParam(value = "objeto de entrada", required = true) 
		@ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.listarTodoTipoAccionPerfil().getListaTipoAccionPerfil(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarAplicacionRolxAplicacionxRol", response = AplicacionRol.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AplicacionRol.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarAplicacionRolxAplicacionxRol}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AplicacionRol>  buscarAplicacionRolxAplicacionxRol(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid AplicacionRol objAplicacionRol, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarAplicacionRolxAplicacionxRol(
				objAplicacionRol).getAplicacionRol(),  HttpStatus.OK);
	}
	
	@ApiOperation(value = "crearMember", response = Member.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Member.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearMember}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Member>  crearMember(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Member objMember, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.crearMember(objMember).getMember(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "crearIdentificador", response = Identificador.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Identificador.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearIdentificador}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Identificador>  crearIdentificador(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Identificador objIdentificador, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.crearIdentificador(
				objIdentificador).getIdentificador(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarIdentificadorxValuexPais", response = Identificador.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Identificador.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarIdentificadorxValuexPais}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Identificador>  buscarIdentificadorxValuexPais(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Identificador objIdentificador, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarIdentificadorxValuexPais(
				objIdentificador).getIdentificador(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "crearAccionPerfil", response = AccionPerfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AccionPerfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.crearAccionPerfil}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccionPerfil>  crearAccionPerfil(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid AccionPerfil objAccionPerfil, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.crearAccionPerfil(objAccionPerfil).getAccionPerfil(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarAccionPerfilxPerfilxTipoAccionxKeyAccion", response = AccionPerfil.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AccionPerfil.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarAccionPerfilxPerfilxTipoAccionxKeyAccion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AccionPerfil>  buscarAccionPerfilxPerfilxTipoAccionxKeyAccion(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid AccionPerfil objAccionPerfil, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarAccionPerfilxPerfilxTipoAccionxKeyAccion(
				objAccionPerfil).getAccionPerfil(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "listarMaquinaEmpresaxEmpresa", response = MaquinaEmpresa.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = MaquinaEmpresa.class)
	})
	@PostMapping(value = "${servicio.app.uri.listarMaquinaEmpresaxEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<MaquinaEmpresa> listarMaquinaEmpresaxEmpresa(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid MaquinaEmpresa objMaquinaEmpresa, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.listarMaquinaEmpresaxEmpresa(
				objMaquinaEmpresa).getMaquinaEmpresa(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarAplicacionEmpresaxAplicacionxEmpresa", response = AplicacionEmpresa.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AplicacionEmpresa.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarAplicacionEmpresaxAplicacionxEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AplicacionEmpresa>  buscarAplicacionEmpresaxAplicacionxEmpresa(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid AplicacionEmpresa objAplicacionEmpresa, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarAplicacionEmpresaxAplicacionxEmpresa(objAplicacionEmpresa).getAplicacionEmpresa(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarConfiguracionEmpresaUsuarioxEmpresa", response = ConfiguracionEmpresaUsuario.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = ConfiguracionEmpresaUsuario.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarConfiguracionEmpresaUsuarioxEmpresa}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ConfiguracionEmpresaUsuario>  buscarConfiguracionEmpresaUsuarioxEmpresa(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid ConfiguracionEmpresaUsuario objConfiguracionEmpresaUsuario, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarConfiguracionEmpresaUsuarioxEmpresa(
				objConfiguracionEmpresaUsuario).getConfiguracionEmpresaUsuario(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarUsuarioxCodigo", response = Usuario.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = Usuario.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarUsuarioxCodigo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario>  buscarUsuarioxCodigo(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid Usuario objUsuario, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarUsuarioxCodigo(objUsuario).getUsuario(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarEmpresaUsuarioxEmpresaxUsuarioxRol", response = EmpresaUsuario.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = EmpresaUsuario.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarEmpresaUsuarioxEmpresaxUsuarioxRol}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaUsuario>  buscarEmpresaUsuarioxEmpresaxUsuarioxRol(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid EmpresaUsuario objEmpresaUsuario, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarEmpresaUsuarioxEmpresaxUsuarioxRol(
				objEmpresaUsuario).getEmpresaUsuario(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "listarEmpresaUsuarioxEmpresaxRol", response = EmpresaUsuario.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = EmpresaUsuario.class)
	})
	@PostMapping(value = "${servicio.app.uri.listarEmpresaUsuarioxEmpresaxRol}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaUsuario>  listarEmpresaUsuarioxEmpresaxRol(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid EmpresaUsuario objEmpresaUsuario, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.listarEmpresaUsuarioxEmpresaxRol(
				objEmpresaUsuario).getEmpresaUsuario(),  HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp", response = AplicacionServicio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AplicacionServicio.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AplicacionServicio>  buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid AplicacionServicio objAplicacionServicio, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(
				objAplicacionServicio).getAplicacionServicio(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "listarAplicacionServicioxAplicacion", response = AplicacionServicio.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = AplicacionServicio.class)
	})
	@PostMapping(value = "${servicio.app.uri.listarAplicacionServicioxAplicacion}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AplicacionServicio>  listarAplicacionServicioxAplicacion(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid AplicacionServicio objAplicacionServicio, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.listarAplicacionServicioxAplicacion(objAplicacionServicio).getAplicacionServicio(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "buscarEmpresaUsuarioAplicacionEmpresaxEUxAE", response = EmpresaUsuarioAplicacionEmpresa.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = EmpresaUsuarioAplicacionEmpresa.class)
	})
	@PostMapping(value = "${servicio.app.uri.buscarEmpresaUsuarioAplicacionEmpresaxEUxAE}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmpresaUsuarioAplicacionEmpresa>  buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid EmpresaUsuarioAplicacionEmpresa objEmpresaUsuarioAplicacionEmpresa, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(
				objEmpresaUsuarioAplicacionEmpresa).getEmpresaUsuarioAplicacionEmpresa(), HttpStatus.OK);
	}
	
	@ApiOperation(value = "listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio", response = SeguridadAplicacionAcceso.class)
	@ApiResponses(value = {
			@ApiResponse(code = 422, message = "Error al procesar los datos", response = RagnaxError.class),
			@ApiResponse(code = 503, message = "Error con el servicio", response = RagnaxError.class),
			@ApiResponse(code = 200, message = "Servicio ejecutado satisfactoriamente", response = SeguridadAplicacionAcceso.class)
	})
	@PostMapping(value = "${servicio.app.uri.listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<SeguridadAplicacionAcceso>>  listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio(  @ApiParam(value = "objeto de entrada", required = true) 
	@RequestBody @Valid SeguridadAplicacionAcceso objSeguridadAplicacionAcceso, @ApiIgnore Errors errors)  throws LogicaImplException{

		return new ResponseEntity<>(factorySSSOService.listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio(
				objSeguridadAplicacionAcceso).getListaSeguridadAplicacionAcceso(), HttpStatus.OK);
	}

}
