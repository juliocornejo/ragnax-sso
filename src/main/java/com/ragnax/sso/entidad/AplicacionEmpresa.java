package com.ragnax.sso.entidad;

import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for @Entity: AplicacionEmpresa
 * en la base de Datos representa las aplicaciones disponibles para la Empresa en el sistema de la compañia Tesoro del Cielo.
 *
 */
@Entity
@Table (name="aplicacion_empresa")

public class AplicacionEmpresa{

	@Id
	@OrderBy
	@Column(name="id_aplicacion_empresa")
	private Integer idAplicacionEmpresa;

	@OrderBy
	@ManyToOne
	@JoinColumn(name="fk_id_aplicacion")
	private Aplicacion idAplicacion;
	
	@OrderBy
	@ManyToOne
	@JoinColumn(name="fk_id_empresa")
	private Empresa idEmpresa;
	
	@OrderBy
	@Column(name="estado_aplicacion_empresa")
	private Boolean estadoAplicacionEmpresa;
	
	@OneToMany(mappedBy="idAplicacionEmpresa")
	private List<EmpresaUsuarioAplicacionEmpresa> empresas_usuarios_aplicaciones_empresas;
	
	public AplicacionEmpresa() {
		super();
	}
	
	public AplicacionEmpresa(Aplicacion idAplicacion, Empresa idEmpresa) {
		super();
		this.idAplicacion = idAplicacion;
		this.idEmpresa = idEmpresa;
	}

	public Integer getIdAplicacionEmpresa() {
		return idAplicacionEmpresa;
	}

	public void setIdAplicacionEmpresa(Integer idAplicacionEmpresa) {
		this.idAplicacionEmpresa = idAplicacionEmpresa;
	}

	public Aplicacion getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(Aplicacion idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public Empresa getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Empresa idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Boolean getEstadoAplicacionEmpresa() {
		return estadoAplicacionEmpresa;
	}

	public void setEstadoAplicacionEmpresa(Boolean estadoAplicacionEmpresa) {
		this.estadoAplicacionEmpresa = estadoAplicacionEmpresa;
	}

	public List<EmpresaUsuarioAplicacionEmpresa> getEmpresas_usuarios_aplicaciones_empresas() {
		return empresas_usuarios_aplicaciones_empresas;
	}

	public void setEmpresas_usuarios_aplicaciones_empresas(
			List<EmpresaUsuarioAplicacionEmpresa> empresas_usuarios_aplicaciones_empresas) {
		this.empresas_usuarios_aplicaciones_empresas = empresas_usuarios_aplicaciones_empresas;
	}
	
}
