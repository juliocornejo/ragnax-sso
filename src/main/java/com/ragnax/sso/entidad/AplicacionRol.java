package com.ragnax.sso.entidad;

import javax.persistence.*;


/**
 *  implementation class for @Entity: AplicacionRol
 * en la base de Datos representa los roles establecidos para ejecutar acciones en las aplicación 
 */
@Entity
@Table (name="aplicacion_rol")

public class AplicacionRol{

	@Id
	@OrderBy
	@Column(name="id_aplicacion_rol")
	private Integer idAplicacionRol;
	
	@OrderBy
	@ManyToOne
	@JoinColumn(name="fk_id_aplicacion")
	private Aplicacion idAplicacion;

	@OrderBy
	@ManyToOne
	@JoinColumn(name="fk_id_rol")
	private Rol idRol;
	
	@OrderBy
	@Column(name="estado_aplicacion_rol")
	private Boolean estadoAplicacionRol;
	
	public AplicacionRol() {
		super();
	}
	
	public AplicacionRol(Aplicacion idAplicacion, Rol idRol) {
		super();
		this.idAplicacion = idAplicacion;
		this.idRol = idRol;
	}

	public Integer getIdAplicacionRol() {
		return idAplicacionRol;
	}

	public void setIdAplicacionRol(Integer idAplicacionRol) {
		this.idAplicacionRol = idAplicacionRol;
	}

	public Aplicacion getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(Aplicacion idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public Rol getIdRol() {
		return idRol;
	}

	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}

	public Boolean getEstadoAplicacionRol() {
		return estadoAplicacionRol;
	}

	public void setEstadoAplicacionRol(Boolean estadoAplicacionRol) {
		this.estadoAplicacionRol = estadoAplicacionRol;
	}
	
}
