package com.ragnax.sso.entidad;

import javax.persistence.*;

/**
 *  implementation class for @Entity: SeguridadAplicacionAcceso
 * en la base de Datos representa los roles establecidos para ejecutar acciones en las aplicación 
 */
@Entity
@Table (name="seguridad_aplicacion_acceso")
public class SeguridadAplicacionAcceso{

	@Id
	@OrderBy
	@Column(name="id_seguridad_aplicacion_acceso")
	private Integer idSeguridadAplicacionAcceso;
	
	@OrderBy
	@ManyToOne(targetEntity=EmpresaUsuarioAplicacionEmpresa.class, fetch=FetchType.EAGER)
	@JoinColumn(name="fk_id_empresa_usuario_aplicacion_empresa")
	private EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa;
	
	@OrderBy
	@ManyToOne
	@JoinColumn(name="fk_id_aplicacion_servicio")
	private AplicacionServicio idAplicacionServicio;
	
	@OrderBy
	@Column(name="estado_seguridad_aplicacion_acceso")
	private Boolean estadoSeguridadAplicacionAcceso;

	public SeguridadAplicacionAcceso() {
		super();
	}
	
	public SeguridadAplicacionAcceso(EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa,
			AplicacionServicio idAplicacionServicio) {
		super();
		this.idEmpresaUsuarioAplicacionEmpresa = idEmpresaUsuarioAplicacionEmpresa;
		this.idAplicacionServicio = idAplicacionServicio;
	}
	
	public SeguridadAplicacionAcceso(EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa,
			AplicacionServicio idAplicacionServicio, Boolean estadoSeguridadAplicacionAcceso) {
		super();
		this.idEmpresaUsuarioAplicacionEmpresa = idEmpresaUsuarioAplicacionEmpresa;
		this.idAplicacionServicio = idAplicacionServicio;
		this.estadoSeguridadAplicacionAcceso = estadoSeguridadAplicacionAcceso;
	}

	public Integer getIdSeguridadAplicacionAcceso() {
		return idSeguridadAplicacionAcceso;
	}

	public void setIdSeguridadAplicacionAcceso(Integer idSeguridadAplicacionAcceso) {
		this.idSeguridadAplicacionAcceso = idSeguridadAplicacionAcceso;
	}

	public EmpresaUsuarioAplicacionEmpresa getIdEmpresaUsuarioAplicacionEmpresa() {
		return idEmpresaUsuarioAplicacionEmpresa;
	}

	public void setIdEmpresaUsuarioAplicacionEmpresa(EmpresaUsuarioAplicacionEmpresa idEmpresaUsuarioAplicacionEmpresa) {
		this.idEmpresaUsuarioAplicacionEmpresa = idEmpresaUsuarioAplicacionEmpresa;
	}

	public AplicacionServicio getIdAplicacionServicio() {
		return idAplicacionServicio;
	}

	public void setIdAplicacionServicio(AplicacionServicio idAplicacionServicio) {
		this.idAplicacionServicio = idAplicacionServicio;
	}

	public Boolean getEstadoSeguridadAplicacionAcceso() {
		return estadoSeguridadAplicacionAcceso;
	}

	public void setEstadoSeguridadAplicacionAcceso(Boolean estadoSeguridadAplicacionAcceso) {
		this.estadoSeguridadAplicacionAcceso = estadoSeguridadAplicacionAcceso;
	}
	
}
