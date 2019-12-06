package com.ragnax.sso.entidad;

import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for @Entity: Genero
 * en la base de Datos representa el detalle de las personas registradas para el servicio de SSO.
 */
@Entity
@Table (name="genero")

public class Genero{
 
	@Id
	@OrderBy
	@Column(name="id_genero")
	private Integer idGenero;
	
	@Column(name="nombre_genero")
	private String nombreGenero;
	
	@Column(name="descripcion_genero")
	private String descripcionGenero;
	
	@Column(name="estado_genero")
	private Boolean estadoGenero;
	
	//Un Persona "member" puede tener muchos usuarios. 
	//pero un usuario jcornej solo puede estar en una Persona "member" 
	//@OneToMany(fetch = FetchType.EAGER, mappedBy="idMember")
	@OneToMany(mappedBy = "idGenero", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval=true)
	private List<Member> members_generos;
	
	public Genero() {
		super();
	}
	
	public Genero(String nombreGenero) {
		super();
		this.nombreGenero = nombreGenero;
	}
	
	public Genero(String nombreGenero, String descripcionGenero) {
		super();
		this.nombreGenero = nombreGenero;
		this.descripcionGenero = descripcionGenero;
	}

	public Integer getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Integer idGenero) {
		this.idGenero = idGenero;
	}

	public String getNombreGenero() {
		return nombreGenero;
	}

	public void setNombreGenero(String nombreGenero) {
		this.nombreGenero = nombreGenero;
	}

	public String getDescripcionGenero() {
		return descripcionGenero;
	}

	public void setDescripcionGenero(String descripcionGenero) {
		this.descripcionGenero = descripcionGenero;
	}

	public Boolean getEstadoGenero() {
		return estadoGenero;
	}

	public void setEstadoGenero(Boolean estadoGenero) {
		this.estadoGenero = estadoGenero;
	}

	public List<Member> getMembers_generos() {
		return members_generos;
	}

	public void setMembers_generos(List<Member> members_generos) {
		this.members_generos = members_generos;
	}
}
