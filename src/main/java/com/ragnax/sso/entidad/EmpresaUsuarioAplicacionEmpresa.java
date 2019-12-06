package com.ragnax.sso.entidad;

import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for @Entity: EmpresaUsuarioAplicacionEmpresa
 * en la base de Datos representa las Empresas y Usuarios asociados. y las aplicaciones contratadas por la empresa que pueden ejecutar en el Sistema
 *
 */
@Entity
@Table (name="empresa_usuario_aplicacion_empresa")

public class EmpresaUsuarioAplicacionEmpresa {
 
	@Id
	@OrderBy
	@Column(name="id_empresa_usuario_aplicacion_empresa")
	private Integer idEmpresaUsuarioAplicacionEmpresa;
	
	@ManyToOne
	@JoinColumn(name="fk_id_empresa_usuario")
	private EmpresaUsuario idEmpresaUsuario;
	
	@ManyToOne
	@JoinColumn(name="fk_id_aplicacion_empresa")
	private AplicacionEmpresa idAplicacionEmpresa;
	
	@OrderBy
	@Column(name="estado_empresa_usuario_aplicacion_empresa")
	private Boolean estadoEmpresaUsuarioAplicacionEmpresa;
	
	@OneToMany(mappedBy="idEmpresaUsuarioAplicacionEmpresa") //el atributo de la clase
	private List<SeguridadAplicacionAcceso> seguridades_aplicaciones_accesos;
	
	public EmpresaUsuarioAplicacionEmpresa() {
		super();
	}
	
	public EmpresaUsuarioAplicacionEmpresa(EmpresaUsuario idEmpresaUsuario) {
		super();
		this.idEmpresaUsuario = idEmpresaUsuario;
	}
	
	public EmpresaUsuarioAplicacionEmpresa(EmpresaUsuario idEmpresaUsuario, AplicacionEmpresa idAplicacionEmpresa) {
		super();
		this.idEmpresaUsuario = idEmpresaUsuario;
		this.idAplicacionEmpresa = idAplicacionEmpresa;
	}

	public Integer getIdEmpresaUsuarioAplicacionEmpresa() {
		return idEmpresaUsuarioAplicacionEmpresa;
	}

	public void setIdEmpresaUsuarioAplicacionEmpresa(Integer idEmpresaUsuarioAplicacionEmpresa) {
		this.idEmpresaUsuarioAplicacionEmpresa = idEmpresaUsuarioAplicacionEmpresa;
	}

	public EmpresaUsuario getIdEmpresaUsuario() {
		return idEmpresaUsuario;
	}

	public void setIdEmpresaUsuario(EmpresaUsuario idEmpresaUsuario) {
		this.idEmpresaUsuario = idEmpresaUsuario;
	}

	public AplicacionEmpresa getIdAplicacionEmpresa() {
		return idAplicacionEmpresa;
	}

	public void setIdAplicacionEmpresa(AplicacionEmpresa idAplicacionEmpresa) {
		this.idAplicacionEmpresa = idAplicacionEmpresa;
	}

	public Boolean getEstadoEmpresaUsuarioAplicacionEmpresa() {
		return estadoEmpresaUsuarioAplicacionEmpresa;
	}

	public void setEstadoEmpresaUsuarioAplicacionEmpresa(Boolean estadoEmpresaUsuarioAplicacionEmpresa) {
		this.estadoEmpresaUsuarioAplicacionEmpresa = estadoEmpresaUsuarioAplicacionEmpresa;
	}

	public List<SeguridadAplicacionAcceso> getSeguridades_aplicaciones_accesos() {
		return seguridades_aplicaciones_accesos;
	}

	public void setSeguridades_aplicaciones_accesos(List<SeguridadAplicacionAcceso> seguridades_aplicaciones_accesos) {
		this.seguridades_aplicaciones_accesos = seguridades_aplicaciones_accesos;
	}
	
}
