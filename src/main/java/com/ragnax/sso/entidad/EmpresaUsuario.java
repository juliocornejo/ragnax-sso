package com.ragnax.sso.entidad;

import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for @Entity: EmpresaUsuario
 * en la base de Datos representa las Empresas y Usuarios asociados.
 *
 */
@Entity
@Table (name="empresa_usuario")

public class EmpresaUsuario {

	@Id
	@OrderBy
	@Column(name="id_empresa_usuario")
	private Integer idEmpresaUsuario;
	
	@ManyToOne(targetEntity=Empresa.class, fetch=FetchType.EAGER)
	@JoinColumn(name="fk_id_empresa")
	private Empresa idEmpresa;
	
	@ManyToOne(targetEntity=Usuario.class, fetch=FetchType.EAGER)
	@JoinColumn(name="fk_id_usuario")
	private Usuario idUsuario;
	
	@OrderBy
	@ManyToOne(targetEntity=Rol.class, fetch=FetchType.EAGER)
	@JoinColumn(name="fk_id_rol")
	private Rol idRol;
	
	@OrderBy
	@Column(name="estado_empresa_usuario")
	private Boolean estadoEmpresaUsuario;
	
	@OneToMany(mappedBy="idEmpresaUsuario")
	private List<EmpresaUsuarioAplicacionEmpresa> empresas_usuarios_aplicaciones_empresas;

	public EmpresaUsuario() {
		super();
	}
	
	public EmpresaUsuario(Empresa idEmpresa, Usuario idUsuario, Rol idRol) {
		super();
		this.idEmpresa = idEmpresa;
		this.idUsuario = idUsuario;
		this.idRol = idRol;
	}

	public Integer getIdEmpresaUsuario() {
		return idEmpresaUsuario;
	}

	public void setIdEmpresaUsuario(Integer idEmpresaUsuario) {
		this.idEmpresaUsuario = idEmpresaUsuario;
	}

	public Empresa getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Usuario getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Usuario idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Rol getIdRol() {
		return idRol;
	}

	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}

	public Boolean getEstadoEmpresaUsuario() {
		return estadoEmpresaUsuario;
	}

	public void setEstadoEmpresaUsuario(Boolean estadoEmpresaUsuario) {
		this.estadoEmpresaUsuario = estadoEmpresaUsuario;
	}

	public List<EmpresaUsuarioAplicacionEmpresa> getEmpresas_usuarios_aplicaciones_empresas() {
		return empresas_usuarios_aplicaciones_empresas;
	}

	public void setEmpresas_usuarios_aplicaciones_empresas(
			List<EmpresaUsuarioAplicacionEmpresa> empresas_usuarios_aplicaciones_empresas) {
		this.empresas_usuarios_aplicaciones_empresas = empresas_usuarios_aplicaciones_empresas;
	}
}
