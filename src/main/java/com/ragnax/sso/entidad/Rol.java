package com.ragnax.sso.entidad;

import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for @Entity: Rol
 * en la base de Datos representa las acciones que puede realizar un Usuario en las aplicaciones del servicio
 */
@Entity
@Table (name="rol")
public class Rol{
 
	@Id
	@OrderBy
	@Column(name="id_rol")
	private Integer idRol;
	
	@OrderBy
	@Column(name="nombre_rol")
	private String nombreRol; //Nombre a Mostrar
	
	@OrderBy
	@Column(name="nombre_rol_lower")
	private String nombreRolLowerCase; //nombre a comprobar
	
	@Column(name="descripcion_rol")
	private String descripcionRol;
	
	@OrderBy
	@Column(name="estado_rol")
	private Boolean estadoRol;
	
	@OneToMany(mappedBy="idRol")
	private List<AplicacionRol> aplicaciones_roles;
	
	@OneToMany(mappedBy="idRol")
	private List<EmpresaUsuario> empresas_usuarios;
	
	public Rol() {
		super();
	}
	
	public Rol(String nombreRol) {
		super();
		this.nombreRol = nombreRol;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public String getNombreRolLowerCase() {
		return nombreRolLowerCase;
	}

	public String getDescripcionRol() {
		return descripcionRol;
	}

	public Boolean getEstadoRol() {
		return estadoRol;
	}

	public List<AplicacionRol> getAplicaciones_roles() {
		return aplicaciones_roles;
	}

	public List<EmpresaUsuario> getEmpresas_usuarios() {
		return empresas_usuarios;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public void setNombreRolLowerCase(String nombreRolLowerCase) {
		this.nombreRolLowerCase = nombreRolLowerCase;
	}

	public void setDescripcionRol(String descripcionRol) {
		this.descripcionRol = descripcionRol;
	}

	public void setEstadoRol(Boolean estadoRol) {
		this.estadoRol = estadoRol;
	}

	public void setAplicaciones_roles(List<AplicacionRol> aplicaciones_roles) {
		this.aplicaciones_roles = aplicaciones_roles;
	}

	public void setEmpresas_usuarios(List<EmpresaUsuario> empresas_usuarios) {
		this.empresas_usuarios = empresas_usuarios;
	}
}
