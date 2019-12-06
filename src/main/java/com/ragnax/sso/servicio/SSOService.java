package com.ragnax.sso.servicio;

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

public interface SSOService {
	
	SSO crearRol(Rol objRol) throws LogicaImplException;
	
	SSO buscarRolxNombre(Rol objRol) throws LogicaImplException;
	
	SSO listarTodoRol() throws LogicaImplException;
	
	SSO crearAplicacion(Aplicacion objAplicacion) throws LogicaImplException;
	
	SSO buscarAplicacion(Aplicacion objAplicacion) throws LogicaImplException;
	
	SSO buscarAplicacionxUriRuta(Aplicacion objAplicacion) throws LogicaImplException;
	
	SSO listarTodoAplicacion() throws LogicaImplException;
	
	SSO crearMaquina(Maquina objMaquina) throws LogicaImplException;
	
	SSO buscarMaquinaxDireccionIpMaquina(Maquina objMaquina) throws LogicaImplException;
	
	SSO crearGenero(Genero objGenero) throws LogicaImplException;
	
	SSO buscarGeneroxNombre(Genero objGenero) throws LogicaImplException;
	
	SSO listarTodoGenero() throws LogicaImplException;
	
	SSO crearTipoAccionPerfil(TipoAccionPerfil objTipoAccionPerfil) throws LogicaImplException;
	
	SSO buscarTipoAccionPerfil(TipoAccionPerfil objTipoAccionPerfil) throws LogicaImplException;
	
	SSO listarTodoTipoAccionPerfil()  throws LogicaImplException;
	
	SSO crearEmpresa(Empresa objEmpresa) throws LogicaImplException;
	
	SSO buscarEmpresa(Empresa objEmpresa) throws LogicaImplException;
	
	SSO buscarEmpresaxDominio(Empresa objEmpresa) throws LogicaImplException;
	
	SSO listarEmpresaxIdPais(Empresa objEmpresa) throws LogicaImplException;
	
	SSO listarTodoEmpresa() throws LogicaImplException;
	
	SSO crearConfiguracionEmpresaUsuario(ConfiguracionEmpresaUsuario objConfiguracionEmpresaUsuario) throws LogicaImplException;
	
	SSO buscarConfiguracionEmpresaUsuarioxEmpresa(ConfiguracionEmpresaUsuario objConfiguracionEmpresaUsuario) throws LogicaImplException;
	
	SSO crearMember(Member objMember) throws LogicaImplException;
	
	SSO buscarMember(Member objMember) throws LogicaImplException;
	
	SSO listarTodoMember() throws LogicaImplException;
	
	SSO crearPerfil(Perfil objPerfil) throws LogicaImplException;
	
	SSO buscarPerfil(Perfil objPerfil) throws LogicaImplException;
	
	SSO buscarPerfilxUsername(Perfil objPerfil) throws LogicaImplException;
	
	SSO buscarPerfilxUsernameLike(Perfil objPerfil) throws LogicaImplException;
	
	SSO buscarPerfilxUsernamexPasswordContrasenha(Perfil objPerfil) throws LogicaImplException;
	
	SSO buscarPerfilxEmail(Perfil objPerfil) throws LogicaImplException;
	
	SSO listarTodoPerfil() throws LogicaImplException;
	
	SSO crearFotoPerfil(FotoPerfil objFotoPerfil) throws LogicaImplException;

	SSO generarCodigoUsuario(Usuario objUsuario) throws LogicaImplException;
	
	SSO crearUsuario(Usuario objUsuario) throws LogicaImplException;
	/****Buscar Exclusivamente siempre por codigoUsuario *******/
	SSO buscarUsuarioxCodigo(Usuario objUsuario) throws LogicaImplException ;
	
	SSO listarTodoUsuario() throws LogicaImplException;
	
	SSO crearAplicacionEmpresa(AplicacionEmpresa objAplicacionEmpresa) throws LogicaImplException;
	
	SSO buscarAplicacionEmpresaxAplicacionxEmpresa(AplicacionEmpresa objAplicacionEmpresa) throws LogicaImplException;
	
	SSO listarAplicacionEmpresaxEmpresa(AplicacionEmpresa objAplicacionEmpresa) throws LogicaImplException;
	
	SSO crearAplicacionRol(AplicacionRol objAplicacionRol) throws LogicaImplException;
	
	SSO buscarAplicacionRolxAplicacionxRol(AplicacionRol objAplicacionRol) throws LogicaImplException;
	
	SSO crearIdentificador(Identificador objIdentificador) throws LogicaImplException;
	
	SSO buscarIdentificadorxValuexPais(Identificador objIdentificador) throws LogicaImplException;
	
	SSO crearAccionPerfil(AccionPerfil objAccionPerfil) throws LogicaImplException;
	
	SSO buscarAccionPerfilxPerfilxTipoAccionxKeyAccion(AccionPerfil objAccionPerfil) throws LogicaImplException;
	
	SSO crearMaquinaEmpresa(MaquinaEmpresa objMaquinaEmpresa) throws LogicaImplException;
	
	SSO listarMaquinaEmpresaxEmpresa(MaquinaEmpresa objMaquinaEmpresa) throws LogicaImplException;
	
	SSO crearEmpresaUsuario(EmpresaUsuario objEmpresaUsuario) throws LogicaImplException;
	
	SSO buscarEmpresaUsuario(EmpresaUsuario objEmpresaUsuario) throws LogicaImplException;
	
	SSO buscarEmpresaUsuarioxEmpresaxUsuarioxRol(EmpresaUsuario objEmpresaUsuario) throws LogicaImplException;
	
	SSO listarEmpresaUsuarioxEmpresa(EmpresaUsuario objEmpresaUsuario)  throws LogicaImplException;
	
	SSO listarEmpresaUsuarioxEmpresaxRol(EmpresaUsuario objEmpresaUsuario)  throws LogicaImplException;
	
	SSO crearAplicacionServicio(AplicacionServicio objAplicacionServicio)  throws LogicaImplException;
	
	SSO buscarAplicacionServicio(AplicacionServicio objAplicacionServicio)  throws LogicaImplException;
	
	SSO buscarAplicacionServicioxAplicacionxUriRutaxMetodoHttp(AplicacionServicio objAplicacionServicio) throws LogicaImplException;
	
	SSO listarAplicacionServicioxAplicacion(AplicacionServicio objAplicacionServicio) throws LogicaImplException;
	
	SSO listarTodoAplicacionServicio() throws LogicaImplException;
	
	SSO crearEmpresaUsuarioAplicacionEmpresa(EmpresaUsuarioAplicacionEmpresa objEUAE) throws LogicaImplException;
	
	SSO buscarEmpresaUsuarioAplicacionEmpresa(EmpresaUsuarioAplicacionEmpresa objEUAE) throws LogicaImplException;
	
	SSO buscarEmpresaUsuarioAplicacionEmpresaxEUxAE(EmpresaUsuarioAplicacionEmpresa objEUAE) throws LogicaImplException;
	
	SSO listarEmpresaUsuarioAplicacionEmpresaxEU(EmpresaUsuarioAplicacionEmpresa objEUAE) throws LogicaImplException;
	
	SSO crearSeguridadAplicacionAcceso(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso) throws LogicaImplException;
	
	SSO buscarSeguridadAplicacionAcceso(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso) throws LogicaImplException;
	
	SSO listarSeguridadAplicacionAccesoxEUAExListaAplicacionServicio(SeguridadAplicacionAcceso objSeguridadAplicacionAcceso) throws LogicaImplException;
	
}
