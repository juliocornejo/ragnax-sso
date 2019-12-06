package com.ragnax.sso.entidad;

import java.sql.Timestamp;

import javax.persistence.*;

/**
 *  implementation class for @Entity: SeguridadSessionPlataforma
 * en la base de Datos representa los roles establecidos para ejecutar acciones en las aplicación 
 */
@Entity
@Table (name="seguridad_session_plataforma")
public class SeguridadSessionPlataforma{

	@Id
	@OrderBy
	@Column(name="id_seguridad_session_plataforma")
	private Integer idSeguridadSessionPlataforma;
	
	@Lob
	@Column(name="key_seguridad_session_plataforma", length = 5000)
	private String keySeguridadSessionPlataforma;
	
	@Lob
	@Column(name="value_64_seguridad_session_plataforma", length = 10000)
	private String value64SeguridadSessionPlataforma;
	
	@OrderBy
	@Column(name="estado_seguridad_session_plataforma")
	private Integer estadoSeguridadSessionPlataforma;
	
	@OrderBy
	@Column(name="fecha_creacion_seguridad_session_plataforma")
	private Timestamp fechaCreacionSeguridadSessionPlataforma;
	
	@OrderBy
	@Column(name="fecha_expiracion_seguridad_session_plataforma")
	private Timestamp fechaExpiracionSeguridadSessionPlataforma;

	public SeguridadSessionPlataforma() {
		super();
	}

	public Integer getIdSeguridadSessionPlataforma() {
		return idSeguridadSessionPlataforma;
	}

	public void setIdSeguridadSessionPlataforma(Integer idSeguridadSessionPlataforma) {
		this.idSeguridadSessionPlataforma = idSeguridadSessionPlataforma;
	}

	public String getKeySeguridadSessionPlataforma() {
		return keySeguridadSessionPlataforma;
	}

	public void setKeySeguridadSessionPlataforma(String keySeguridadSessionPlataforma) {
		this.keySeguridadSessionPlataforma = keySeguridadSessionPlataforma;
	}

	public String getValue64SeguridadSessionPlataforma() {
		return value64SeguridadSessionPlataforma;
	}

	public void setValue64SeguridadSessionPlataforma(String value64SeguridadSessionPlataforma) {
		this.value64SeguridadSessionPlataforma = value64SeguridadSessionPlataforma;
	}

	public Integer getEstadoSeguridadSessionPlataforma() {
		return estadoSeguridadSessionPlataforma;
	}

	public void setEstadoSeguridadSessionPlataforma(Integer estadoSeguridadSessionPlataforma) {
		this.estadoSeguridadSessionPlataforma = estadoSeguridadSessionPlataforma;
	}

	public Timestamp getFechaCreacionSeguridadSessionPlataforma() {
		return fechaCreacionSeguridadSessionPlataforma;
	}

	public void setFechaCreacionSeguridadSessionPlataforma(Timestamp fechaCreacionSeguridadSessionPlataforma) {
		this.fechaCreacionSeguridadSessionPlataforma = fechaCreacionSeguridadSessionPlataforma;
	}

	public Timestamp getFechaExpiracionSeguridadSessionPlataforma() {
		return fechaExpiracionSeguridadSessionPlataforma;
	}

	public void setFechaExpiracionSeguridadSessionPlataforma(Timestamp fechaExpiracionSeguridadSessionPlataforma) {
		this.fechaExpiracionSeguridadSessionPlataforma = fechaExpiracionSeguridadSessionPlataforma;
	}

	

	
}

