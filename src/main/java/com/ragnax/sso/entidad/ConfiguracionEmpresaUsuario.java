package com.ragnax.sso.entidad;

import java.lang.String;

import javax.persistence.*;

/**
 *  implementation class for @Entity: ConfiguracionEmpresaUsuario
 * en la base de Datos representa el registro de las personas asociadas al servicio.
 */
@Entity
@Table (name="configuracion_empresa_usuario")

public class ConfiguracionEmpresaUsuario{
 
	@Id
	@OrderBy
	@Column(name="id_configuracion_empresa_usuario")
	private Integer idConfiguracionEmpresaUsuario;
	
	//Para la empresa, formato de la contraseña 256 o normal
	@Column(name="password_contrasenha_format")
	private String passwordEmpresaUsuarioContrasenhaFormat;
	
	//Para la empresa, si va a existir salto o no
	@Column(name="password_contrasenha_salto")
	private Boolean passwordEmpresaUsuarioContrasenhaSalto;
	
	@ManyToOne
	@JoinColumn(name="fk_id_empresa")
	private Empresa idEmpresa;
	
	@OrderBy
	@Column(name="estado_configuracion_empresa_usuario")
	private Boolean estadoConfiguracionEmpresaUsuario;
	
	public ConfiguracionEmpresaUsuario() {
		super();
	}
	
	public ConfiguracionEmpresaUsuario(Empresa idEmpresa, Boolean estadoConfiguracionEmpresaUsuario) {
		super();
		this.idEmpresa = idEmpresa;
		this.estadoConfiguracionEmpresaUsuario = estadoConfiguracionEmpresaUsuario; 
	}
	
	public ConfiguracionEmpresaUsuario(String passwordEmpresaUsuarioContrasenhaFormat,
			Boolean passwordEmpresaUsuarioContrasenhaSalto, Empresa idEmpresa) {
		super();
		this.passwordEmpresaUsuarioContrasenhaFormat = passwordEmpresaUsuarioContrasenhaFormat;
		this.passwordEmpresaUsuarioContrasenhaSalto = passwordEmpresaUsuarioContrasenhaSalto;
		this.idEmpresa = idEmpresa;
	}



	public Integer getIdConfiguracionEmpresaUsuario() {
		return idConfiguracionEmpresaUsuario;
	}

	public void setIdConfiguracionEmpresaUsuario(Integer idConfiguracionEmpresaUsuario) {
		this.idConfiguracionEmpresaUsuario = idConfiguracionEmpresaUsuario;
	}

	public String getPasswordEmpresaUsuarioContrasenhaFormat() {
		return passwordEmpresaUsuarioContrasenhaFormat;
	}

	public void setPasswordEmpresaUsuarioContrasenhaFormat(String passwordEmpresaUsuarioContrasenhaFormat) {
		this.passwordEmpresaUsuarioContrasenhaFormat = passwordEmpresaUsuarioContrasenhaFormat;
	}

	public Boolean getPasswordEmpresaUsuarioContrasenhaSalto() {
		return passwordEmpresaUsuarioContrasenhaSalto;
	}

	public void setPasswordEmpresaUsuarioContrasenhaSalto(Boolean passwordEmpresaUsuarioContrasenhaSalto) {
		this.passwordEmpresaUsuarioContrasenhaSalto = passwordEmpresaUsuarioContrasenhaSalto;
	}

	public Empresa getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Boolean getEstadoConfiguracionEmpresaUsuario() {
		return estadoConfiguracionEmpresaUsuario;
	}

	public void setEstadoConfiguracionEmpresaUsuario(Boolean estadoConfiguracionEmpresaUsuario) {
		this.estadoConfiguracionEmpresaUsuario = estadoConfiguracionEmpresaUsuario;
	}
	
}
