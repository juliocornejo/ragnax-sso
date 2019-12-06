package com.ragnax.sso.controller.response;

import java.io.Serializable;
import java.util.List;

import com.ragnax.sso.entidad.*;

public class SSO implements Serializable{

	private static final long serialVersionUID = -4301293450469130528L;
	
	private Rol rol;
	private Genero genero;
	private TipoAccionPerfil tipoAccionPerfil;
	private Aplicacion aplicacion;
	private Maquina maquina;
	private Empresa empresa;
	private AplicacionRol aplicacionRol;
	private ConfiguracionEmpresaUsuario configuracionEmpresaUsuario;
	private Member member;
	private Perfil perfil;
	private Identificador identificador;
	private FotoPerfil fotoPerfil;
	private AccionPerfil accionPerfil;
	private MaquinaEmpresa maquinaEmpresa;
	private AplicacionEmpresa aplicacionEmpresa;
	private Usuario usuario;
	private EmpresaUsuario empresaUsuario;
	private AplicacionServicio aplicacionServicio;
	private EmpresaUsuarioAplicacionEmpresa empresaUsuarioAplicacionEmpresa;
	private SeguridadAplicacionAcceso seguridadAplicacionAcceso;
	private SeguridadSessionPlataforma seguridadSessionPlataforma;
	
	private List<AccionPerfil> listaAccionPerfil;
	private List<AplicacionEmpresa> listaAplicacionEmpresa;
	private List<Aplicacion> listaAplicacion;
	private List<AplicacionRol> listaAplicacionRol;
	private List<AplicacionServicio> listaAplicacionServicio;
	private List<ConfiguracionEmpresaUsuario> listaConfiguracionEmpresaUsuario;
	private List<Empresa> listaEmpresa;
	private List<EmpresaUsuarioAplicacionEmpresa> listaEmpresaUsuarioAplicacionEmpresa;
	private List<EmpresaUsuario> listaEmpresaUsuario;
	private List<FotoPerfil> listaFotoPerfil;
	private List<Genero> listaGenero;
	private List<Identificador> listaIdentificador;
	private List<MaquinaEmpresa> listaMaquinaEmpresa;
	private List<Maquina> listaMaquina;
	private List<Member> listaMember;
	private List<Perfil> listaPerfil;
	private List<Rol> listaRol;
	private List<SeguridadAplicacionAcceso> listaSeguridadAplicacionAcceso;
	private List<SeguridadSessionPlataforma> listaSeguridadSessionPlataforma;
	private List<TipoAccionPerfil> listaTipoAccionPerfil;
	private List<Usuario> listaUsuario;
	
	public SSO() {
		super();
	}
	
	public AccionPerfil getAccionPerfil() {
		return accionPerfil;
	}

	public void setAccionPerfil(AccionPerfil accionPerfil) {
		this.accionPerfil = accionPerfil;
	}

	public AplicacionEmpresa getAplicacionEmpresa() {
		return aplicacionEmpresa;
	}

	public void setAplicacionEmpresa(AplicacionEmpresa aplicacionEmpresa) {
		this.aplicacionEmpresa = aplicacionEmpresa;
	}

	public Aplicacion getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Aplicacion aplicacion) {
		this.aplicacion = aplicacion;
	}

	public AplicacionRol getAplicacionRol() {
		return aplicacionRol;
	}

	public void setAplicacionRol(AplicacionRol aplicacionRol) {
		this.aplicacionRol = aplicacionRol;
	}

	public AplicacionServicio getAplicacionServicio() {
		return aplicacionServicio;
	}

	public void setAplicacionServicio(AplicacionServicio aplicacionServicio) {
		this.aplicacionServicio = aplicacionServicio;
	}

	public ConfiguracionEmpresaUsuario getConfiguracionEmpresaUsuario() {
		return configuracionEmpresaUsuario;
	}

	public void setConfiguracionEmpresaUsuario(ConfiguracionEmpresaUsuario configuracionEmpresaUsuario) {
		this.configuracionEmpresaUsuario = configuracionEmpresaUsuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public EmpresaUsuarioAplicacionEmpresa getEmpresaUsuarioAplicacionEmpresa() {
		return empresaUsuarioAplicacionEmpresa;
	}

	public void setEmpresaUsuarioAplicacionEmpresa(
			EmpresaUsuarioAplicacionEmpresa empresaUsuarioAplicacionEmpresa) {
		this.empresaUsuarioAplicacionEmpresa = empresaUsuarioAplicacionEmpresa;
	}

	public EmpresaUsuario getEmpresaUsuario() {
		return empresaUsuario;
	}

	public void setEmpresaUsuario(EmpresaUsuario empresaUsuario) {
		this.empresaUsuario = empresaUsuario;
	}

	public FotoPerfil getFotoPerfil() {
		return fotoPerfil;
	}

	public void setFotoPerfil(FotoPerfil fotoPerfil) {
		this.fotoPerfil = fotoPerfil;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Identificador getIdentificador() {
		return identificador;
	}

	public void setIdentificador(Identificador identificador) {
		this.identificador = identificador;
	}

	public MaquinaEmpresa getMaquinaEmpresa() {
		return maquinaEmpresa;
	}

	public void setMaquinaEmpresa(MaquinaEmpresa maquinaEmpresa) {
		this.maquinaEmpresa = maquinaEmpresa;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public SeguridadAplicacionAcceso getSeguridadAplicacionAcceso() {
		return seguridadAplicacionAcceso;
	}

	public void setSeguridadAplicacionAcceso(SeguridadAplicacionAcceso seguridadAplicacionAcceso) {
		this.seguridadAplicacionAcceso = seguridadAplicacionAcceso;
	}

	public SeguridadSessionPlataforma getSeguridadSessionPlataforma() {
		return seguridadSessionPlataforma;
	}

	public void setSeguridadSessionPlataforma(SeguridadSessionPlataforma seguridadSessionPlataforma) {
		this.seguridadSessionPlataforma = seguridadSessionPlataforma;
	}

	public TipoAccionPerfil getTipoAccionPerfil() {
		return tipoAccionPerfil;
	}

	public void setTipoAccionPerfil(TipoAccionPerfil tipoAccionPerfil) {
		this.tipoAccionPerfil = tipoAccionPerfil;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<AccionPerfil> getListaAccionPerfil() {
		return listaAccionPerfil;
	}

	public void setListaAccionPerfil(List<AccionPerfil> listaAccionPerfil) {
		this.listaAccionPerfil = listaAccionPerfil;
	}

	public List<AplicacionEmpresa> getListaAplicacionEmpresa() {
		return listaAplicacionEmpresa;
	}

	public void setListaAplicacionEmpresa(List<AplicacionEmpresa> listaAplicacionEmpresa) {
		this.listaAplicacionEmpresa = listaAplicacionEmpresa;
	}

	public List<Aplicacion> getListaAplicacion() {
		return listaAplicacion;
	}

	public void setListaAplicacion(List<Aplicacion> listaAplicacion) {
		this.listaAplicacion = listaAplicacion;
	}

	public List<AplicacionRol> getListaAplicacionRol() {
		return listaAplicacionRol;
	}

	public void setListaAplicacionRol(List<AplicacionRol> listaAplicacionRol) {
		this.listaAplicacionRol = listaAplicacionRol;
	}

	public List<AplicacionServicio> getListaAplicacionServicio() {
		return listaAplicacionServicio;
	}

	public void setListaAplicacionServicio(List<AplicacionServicio> listaAplicacionServicio) {
		this.listaAplicacionServicio = listaAplicacionServicio;
	}

	public List<ConfiguracionEmpresaUsuario> getListaConfiguracionEmpresaUsuario() {
		return listaConfiguracionEmpresaUsuario;
	}

	public void setListaConfiguracionEmpresaUsuario(
			List<ConfiguracionEmpresaUsuario> listaConfiguracionEmpresaUsuario) {
		this.listaConfiguracionEmpresaUsuario = listaConfiguracionEmpresaUsuario;
	}

	public List<Empresa> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<Empresa> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

	public List<EmpresaUsuarioAplicacionEmpresa> getListaEmpresaUsuarioAplicacionEmpresa() {
		return listaEmpresaUsuarioAplicacionEmpresa;
	}

	public void setListaEmpresaUsuarioAplicacionEmpresa(
			List<EmpresaUsuarioAplicacionEmpresa> listaEmpresaUsuarioAplicacionEmpresa) {
		this.listaEmpresaUsuarioAplicacionEmpresa = listaEmpresaUsuarioAplicacionEmpresa;
	}

	public List<EmpresaUsuario> getListaEmpresaUsuario() {
		return listaEmpresaUsuario;
	}

	public void setListaEmpresaUsuario(List<EmpresaUsuario> listaEmpresaUsuario) {
		this.listaEmpresaUsuario = listaEmpresaUsuario;
	}

	public List<FotoPerfil> getListaFotoPerfil() {
		return listaFotoPerfil;
	}

	public void setListaFotoPerfil(List<FotoPerfil> listaFotoPerfil) {
		this.listaFotoPerfil = listaFotoPerfil;
	}

	public List<Genero> getListaGenero() {
		return listaGenero;
	}

	public void setListaGenero(List<Genero> listaGenero) {
		this.listaGenero = listaGenero;
	}

	public List<Identificador> getListaIdentificador() {
		return listaIdentificador;
	}

	public void setListaIdentificador(List<Identificador> listaIdentificador) {
		this.listaIdentificador = listaIdentificador;
	}

	public List<MaquinaEmpresa> getListaMaquinaEmpresa() {
		return listaMaquinaEmpresa;
	}

	public void setListaMaquinaEmpresa(List<MaquinaEmpresa> listaMaquinaEmpresa) {
		this.listaMaquinaEmpresa = listaMaquinaEmpresa;
	}

	public List<Maquina> getListaMaquina() {
		return listaMaquina;
	}

	public void setListaMaquina(List<Maquina> listaMaquina) {
		this.listaMaquina = listaMaquina;
	}

	public List<Member> getListaMember() {
		return listaMember;
	}

	public void setListaMember(List<Member> listaMember) {
		this.listaMember = listaMember;
	}

	public List<Perfil> getListaPerfil() {
		return listaPerfil;
	}

	public void setListaPerfil(List<Perfil> listaPerfil) {
		this.listaPerfil = listaPerfil;
	}

	public List<Rol> getListaRol() {
		return listaRol;
	}

	public void setListaRol(List<Rol> listaRol) {
		this.listaRol = listaRol;
	}

	public List<SeguridadAplicacionAcceso> getListaSeguridadAplicacionAcceso() {
		return listaSeguridadAplicacionAcceso;
	}

	public void setListaSeguridadAplicacionAcceso(
			List<SeguridadAplicacionAcceso> listaSeguridadAplicacionAcceso) {
		this.listaSeguridadAplicacionAcceso = listaSeguridadAplicacionAcceso;
	}

	public List<SeguridadSessionPlataforma> getListaSeguridadSessionPlataforma() {
		return listaSeguridadSessionPlataforma;
	}

	public void setListaSeguridadSessionPlataforma(
			List<SeguridadSessionPlataforma> listaSeguridadSessionPlataforma) {
		this.listaSeguridadSessionPlataforma = listaSeguridadSessionPlataforma;
	}

	public List<TipoAccionPerfil> getListaTipoAccionPerfil() {
		return listaTipoAccionPerfil;
	}

	public void setListaTipoAccionPerfil(List<TipoAccionPerfil> listaTipoAccionPerfil) {
		this.listaTipoAccionPerfil = listaTipoAccionPerfil;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}
	
}
