package com.ragnax.sso.entidad;

import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 *  implementation class for @Entity: AccionPerfil
 * en la base de Datos representa el detalle de las acciones que realiza una persona en el servicio de SSO
 */
@Entity
@Table (name="accion_perfil")

public class AccionPerfil{
 
	@Id
	@OrderBy
	@Column(name="id_accion_perfil")
	private Integer idAccionPerfil;
	
	@Column(name="ultima_accion_perfil")
	private Timestamp ultimaAccionPerfil;
	
	@ManyToOne
	@JoinColumn(name="fk_id_perfil")
	private Perfil idPerfil;
	
	@ManyToOne
	@JoinColumn(name="idx_accion_perfil_fk_id_tipo_accion_perfil")
	private TipoAccionPerfil idTipoAccionPerfil;
	
	@Column(name="key_accion_perfil")
	private String keyAccionPerfil;
	
	//Un Perfil "member" puede tener muchos usuarios.(compartir sessiones - gerentes) 
	//pero un usuario jcornej solo puede estar en un Perfil 
	public AccionPerfil() {
		super();
	}
	
	public AccionPerfil(Object idAccionPerfil) {
		super();
		this.idAccionPerfil = (idAccionPerfil instanceof Integer) ? (Integer) idAccionPerfil : 0;
	}
	
	public AccionPerfil(Perfil idPerfil, TipoAccionPerfil idTipoAccionPerfil, String keyAccionPerfil) {
		super();
		this.idPerfil = idPerfil;
		this.idTipoAccionPerfil = idTipoAccionPerfil;
		this.keyAccionPerfil = keyAccionPerfil;
	}

	public Integer getIdAccionPerfil() {
		return idAccionPerfil;
	}

	public void setIdAccionPerfil(Integer idAccionPerfil) {
		this.idAccionPerfil = idAccionPerfil;
	}

	public Timestamp getUltimaAccionPerfil() {
		return ultimaAccionPerfil;
	}

	public void setUltimaAccionPerfil(Timestamp ultimaAccionPerfil) {
		this.ultimaAccionPerfil = ultimaAccionPerfil;
	}

	public Perfil getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Perfil idPerfil) {
		this.idPerfil = idPerfil;
	}

	public TipoAccionPerfil getIdTipoAccionPerfil() {
		return idTipoAccionPerfil;
	}

	public void setIdTipoAccionPerfil(TipoAccionPerfil idTipoAccionPerfil) {
		this.idTipoAccionPerfil = idTipoAccionPerfil;
	}

	public String getKeyAccionPerfil() {
		return keyAccionPerfil;
	}

	public void setKeyAccionPerfil(String keyAccionPerfil) {
		this.keyAccionPerfil = keyAccionPerfil;
	}
}
