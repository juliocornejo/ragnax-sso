package com.ragnax.sso.entidad;

import java.lang.String;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for @Entity: Aplicacion
 * en la base de Datos representa las aplicaciones disponibles por la empresa Tesoro del Cielo, desarrolladas y disponibles para 
 * nuestros Clientes.
 *
 */
@Entity
//@NamedQuery(name="Aplicacion.findByNombre",query="SELECT apli FROM Aplicacion apli WHERE apli.nombre_aplicacion_lower_case=:nombre_aplicacion_lower_case")
@Table (name="aplicacion")

public class Aplicacion{

	@Id
	@OrderBy
	@Column(name="id_aplicacion")
	private Integer idAplicacion;
	
	@OrderBy
	@Column(name="nombre_aplicacion")
	private String nombreAplicacion; //Nombre del componente Mostrar no es el nombre en la Uri.
	
	@OrderBy
	@Column(name="nombre_aplicacion_lower")
	private String nombreAplicacionLowerCase; //Nombre del componente Mostrar no es el nombre en la Uri.
	
	@OrderBy
	@Column(name="uri_ruta") //codigo unico como el dominio
	private String uriRuta; //codigo unico como el dominio
	
	@OrderBy
	@Column(name="codigo_aplicacion")
	private String codigoAplicacion; //codigo unico
	
	@OrderBy
	@Column(name="descripcion_aplicacion")
	private String descripcionAplicacion; //nombre a comprobar
	
	@OrderBy
	@Column(name="fecha_creacion_aplicacion")
	private Timestamp fechaCreacionAplicacion;
	
	@OneToMany(mappedBy="idAplicacion") //el atributo de la clase
	private List<AplicacionEmpresa> aplicaciones_empresas;
	
	@OneToMany(mappedBy="idAplicacion") //el atributo de la clase
	private List<AplicacionRol> aplicaciones_roles;
	
	@OneToMany(mappedBy="idAplicacion") //el atributo de la clase
	private List<AplicacionServicio> aplicaciones_servicios;
	
	public Aplicacion() {
		super();
	}
	
	public Aplicacion(Object idAplicacion) {
		super();
		this.idAplicacion = (idAplicacion instanceof Integer) ? (Integer) idAplicacion : 0;
	}
	
	public Aplicacion(String nombreAplicacion, String uriRuta, String codigoAplicacion, String descripcionAplicacion) {
		super();
		this.nombreAplicacion = nombreAplicacion;
		this.uriRuta = uriRuta;
		this.codigoAplicacion = codigoAplicacion;
		this.descripcionAplicacion = descripcionAplicacion;
	}

	public Integer getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(Integer idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}

	public String getNombreAplicacionLowerCase() {
		return nombreAplicacionLowerCase;
	}

	public void setNombreAplicacionLowerCase(String nombreAplicacionLowerCase) {
		this.nombreAplicacionLowerCase = nombreAplicacionLowerCase;
	}

	public String getUriRuta() {
		return uriRuta;
	}

	public void setUriRuta(String uriRuta) {
		this.uriRuta = uriRuta;
	}

	public String getCodigoAplicacion() {
		return codigoAplicacion;
	}

	public void setCodigoAplicacion(String codigoAplicacion) {
		this.codigoAplicacion = codigoAplicacion;
	}

	public String getDescripcionAplicacion() {
		return descripcionAplicacion;
	}

	public void setDescripcionAplicacion(String descripcionAplicacion) {
		this.descripcionAplicacion = descripcionAplicacion;
	}

	public Timestamp getFechaCreacionAplicacion() {
		return fechaCreacionAplicacion;
	}

	public void setFechaCreacionAplicacion(Timestamp fechaCreacionAplicacion) {
		this.fechaCreacionAplicacion = fechaCreacionAplicacion;
	}

	public List<AplicacionEmpresa> getAplicaciones_empresas() {
		return aplicaciones_empresas;
	}

	public void setAplicaciones_empresas(List<AplicacionEmpresa> aplicaciones_empresas) {
		this.aplicaciones_empresas = aplicaciones_empresas;
	}

	public List<AplicacionRol> getAplicaciones_roles() {
		return aplicaciones_roles;
	}

	public void setAplicaciones_roles(List<AplicacionRol> aplicaciones_roles) {
		this.aplicaciones_roles = aplicaciones_roles;
	}

	public List<AplicacionServicio> getAplicaciones_servicios() {
		return aplicaciones_servicios;
	}

	public void setAplicaciones_servicios(List<AplicacionServicio> aplicaciones_servicios) {
		this.aplicaciones_servicios = aplicaciones_servicios;
	}
}
