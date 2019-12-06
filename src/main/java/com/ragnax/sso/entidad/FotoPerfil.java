package com.ragnax.sso.entidad;

import java.lang.String;
import java.sql.Timestamp;

import javax.persistence.*;

/**
 *  implementation class for @Entity: FotoPerfil
 * en la base de Datos representa el detalle de las acciones que realiza una persona en el servicio de SSO
 */
@Entity
@Table (name="foto_perfil")

public class FotoPerfil{
 
	@Id
	@OrderBy
	@Column(name="id_foto_perfil")
	private Integer idFotoPerfil;
	
	@Column(name="upload_foto_perfil")
	private Timestamp uploadFotoPerfil;
	
	@Column(name="change_foto_perfil")
	private Timestamp changeFotoPerfil;
	
	@Column(name="repositorio_foto_perfil")
	private String repositorioFotoPerfil;
	
	@Column(name="key_foto_perfil")
	private String keyFotoPerfil;
	
	@ManyToOne
	@JoinColumn(name="fk_id_perfil")
	private Perfil idPerfil;
	
	//Un Perfil "member" puede tener muchos usuarios.(compartir sessiones - gerentes) 
	//pero un usuario jcornej solo puede estar en un Perfil 
	public FotoPerfil() {
		super();
	}

	public FotoPerfil(String repositorioFotoPerfil, String keyFotoPerfil, Perfil idPerfil) {
		super();
		this.repositorioFotoPerfil = repositorioFotoPerfil;
		this.keyFotoPerfil = keyFotoPerfil;
		this.idPerfil = idPerfil;
	}

	public Integer getIdFotoPerfil() {
		return idFotoPerfil;
	}

	public void setIdFotoPerfil(Integer idFotoPerfil) {
		this.idFotoPerfil = idFotoPerfil;
	}

	public Timestamp getUploadFotoPerfil() {
		return uploadFotoPerfil;
	}

	public void setUploadFotoPerfil(Timestamp uploadFotoPerfil) {
		this.uploadFotoPerfil = uploadFotoPerfil;
	}

	public Timestamp getChangeFotoPerfil() {
		return changeFotoPerfil;
	}

	public void setChangeFotoPerfil(Timestamp changeFotoPerfil) {
		this.changeFotoPerfil = changeFotoPerfil;
	}

	public String getRepositorioFotoPerfil() {
		return repositorioFotoPerfil;
	}

	public void setRepositorioFotoPerfil(String repositorioFotoPerfil) {
		this.repositorioFotoPerfil = repositorioFotoPerfil;
	}

	public String getKeyFotoPerfil() {
		return keyFotoPerfil;
	}

	public void setKeyFotoPerfil(String keyFotoPerfil) {
		this.keyFotoPerfil = keyFotoPerfil;
	}

	public Perfil getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Perfil idPerfil) {
		this.idPerfil = idPerfil;
	}
	
}
