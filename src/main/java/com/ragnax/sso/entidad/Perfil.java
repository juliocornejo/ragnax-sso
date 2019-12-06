package com.ragnax.sso.entidad;

import java.lang.String;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for @Entity: Perfil
 * en la base de Datos representa el detalle de las acciones que realiza una persona en el servicio de SSO
 */
@Entity
@Table (name="perfil_usuariounit")

public class Perfil{
 
	@Id
	@OrderBy
	@Column(name="id_perfil")
	private Integer idPerfil;
	@OrderBy
	@Column(name="username_perfil")
	private String usernamePerfil; //Nombre del Usuario el del eventual login
	@OrderBy
	@Column(name="nombre_perfil_lower") 
	private String nombrePerfilLowerCase; //Nombre del Perfil a ver en la pagina del perfil
	
	@Column(name="password_contrasenha_normal")
	private String passwordContrasenhaNormal;
	
	@Column(name="password_contrasenha")
	private String passwordContrasenha;
	
	@OrderBy
	@Column(name="email_perfil")
	private String emailPerfil; //mail usuario
	
	@Column(name="password_pregunta")
	private String passwordPregunta;
	
	@Column(name="password_respuesta")
	private String passwordRespuesta;
	
	@OrderBy
	@Column(name="estado_usuario_perfil")
	private Boolean estadoUsuarioPerfil;
	
	@Column(name="ultima_accion_usuario")
	private Timestamp ultimaAccionUsuario;
	
	@Column(name="ultima_conexion_perfil")
	private Timestamp ultimaConexionPerfil; //ultimo momento en el cual el usuario hizo log-In en el servicio

	@Column(name="password_ultima_actualizacion")
	private Timestamp passwordUltimaActualizacion;
	
	@Column(name="estado_perfil_last_bloqueado")
	private Timestamp estadoPerfilLastBloqueado; 
	
	@Column(name="anonimo")
	private Integer anonimo;
	
	//Un Perfil "member" puede tener muchos usuarios.(compartir sessiones - gerentes) 
	//pero un usuario jcornej solo puede estar en un Perfil 
	//@OneToMany(fetch = FetchType.EAGER, mappedBy="idPerfil")
	@OneToMany(mappedBy = "idPerfil", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval=true)
	private List<Usuario> usuarios_perfiles;
	
	@OneToMany(mappedBy="idPerfil")
	private List<AccionPerfil> acciones_perfiles_perfiles;
	
	@OneToMany(mappedBy="idPerfil")
	private List<FotoPerfil> fotos_perfiles;
	
	public Perfil() {
		super();
	}

	public Perfil(String usernamePerfil, String nombrePerfilLowerCase, String passwordContrasenhaNormal,
			String passwordContrasenha, String emailPerfil, String passwordPregunta, String passwordRespuesta,
			Integer anonimo) {
		super();
		this.usernamePerfil = usernamePerfil;
		this.nombrePerfilLowerCase = nombrePerfilLowerCase;
		this.passwordContrasenhaNormal = passwordContrasenhaNormal;
		this.passwordContrasenha = passwordContrasenha;
		this.emailPerfil = emailPerfil;
		this.passwordPregunta = passwordPregunta;
		this.passwordRespuesta = passwordRespuesta;
		this.anonimo = anonimo;
	}
	
	public Perfil(String usernamePerfil, String passwordContrasenhaNormal) {
		super();
		this.usernamePerfil = usernamePerfil;
		this.passwordContrasenhaNormal = passwordContrasenhaNormal;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getUsernamePerfil() {
		return usernamePerfil;
	}

	public void setUsernamePerfil(String usernamePerfil) {
		this.usernamePerfil = usernamePerfil;
	}

	public String getNombrePerfilLowerCase() {
		return nombrePerfilLowerCase;
	}

	public void setNombrePerfilLowerCase(String nombrePerfilLowerCase) {
		this.nombrePerfilLowerCase = nombrePerfilLowerCase;
	}

	public String getPasswordContrasenhaNormal() {
		return passwordContrasenhaNormal;
	}

	public void setPasswordContrasenhaNormal(String passwordContrasenhaNormal) {
		this.passwordContrasenhaNormal = passwordContrasenhaNormal;
	}

	public String getPasswordContrasenha() {
		return passwordContrasenha;
	}

	public void setPasswordContrasenha(String passwordContrasenha) {
		this.passwordContrasenha = passwordContrasenha;
	}

	public String getEmailPerfil() {
		return emailPerfil;
	}

	public void setEmailPerfil(String emailPerfil) {
		this.emailPerfil = emailPerfil;
	}

	public String getPasswordPregunta() {
		return passwordPregunta;
	}

	public void setPasswordPregunta(String passwordPregunta) {
		this.passwordPregunta = passwordPregunta;
	}

	public String getPasswordRespuesta() {
		return passwordRespuesta;
	}

	public void setPasswordRespuesta(String passwordRespuesta) {
		this.passwordRespuesta = passwordRespuesta;
	}

	public Boolean getEstadoUsuarioPerfil() {
		return estadoUsuarioPerfil;
	}

	public void setEstadoUsuarioPerfil(Boolean estadoUsuarioPerfil) {
		this.estadoUsuarioPerfil = estadoUsuarioPerfil;
	}

	public Timestamp getUltimaAccionUsuario() {
		return ultimaAccionUsuario;
	}

	public void setUltimaAccionUsuario(Timestamp ultimaAccionUsuario) {
		this.ultimaAccionUsuario = ultimaAccionUsuario;
	}

	public Timestamp getUltimaConexionPerfil() {
		return ultimaConexionPerfil;
	}

	public void setUltimaConexionPerfil(Timestamp ultimaConexionPerfil) {
		this.ultimaConexionPerfil = ultimaConexionPerfil;
	}

	public Timestamp getPasswordUltimaActualizacion() {
		return passwordUltimaActualizacion;
	}

	public void setPasswordUltimaActualizacion(Timestamp passwordUltimaActualizacion) {
		this.passwordUltimaActualizacion = passwordUltimaActualizacion;
	}

	public Timestamp getEstadoPerfilLastBloqueado() {
		return estadoPerfilLastBloqueado;
	}

	public void setEstadoPerfilLastBloqueado(Timestamp estadoPerfilLastBloqueado) {
		this.estadoPerfilLastBloqueado = estadoPerfilLastBloqueado;
	}

	public Integer getAnonimo() {
		return anonimo;
	}

	public void setAnonimo(Integer anonimo) {
		this.anonimo = anonimo;
	}

	public List<Usuario> getUsuarios_perfiles() {
		return usuarios_perfiles;
	}

	public void setUsuarios_perfiles(List<Usuario> usuarios_perfiles) {
		this.usuarios_perfiles = usuarios_perfiles;
	}

	public List<AccionPerfil> getAcciones_perfiles_perfiles() {
		return acciones_perfiles_perfiles;
	}

	public void setAcciones_perfiles_perfiles(List<AccionPerfil> acciones_perfiles_perfiles) {
		this.acciones_perfiles_perfiles = acciones_perfiles_perfiles;
	}

	public List<FotoPerfil> getFotos_perfiles() {
		return fotos_perfiles;
	}

	public void setFotos_perfiles(List<FotoPerfil> fotos_perfiles) {
		this.fotos_perfiles = fotos_perfiles;
	}
	
}
