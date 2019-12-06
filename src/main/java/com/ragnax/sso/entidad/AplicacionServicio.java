package com.ragnax.sso.entidad;

import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for @Entity: AplicacionServicio
 * en la base de Datos representa los roles establecidos para ejecutar acciones en las aplicación 
 */
@Entity
@Table (name="aplicacion_servicio")

public class AplicacionServicio{

	@Id
	@OrderBy
	@Column(name="id_aplicacion_servicio")
	private Integer idAplicacionServicio;
	
	@OrderBy
	@ManyToOne
	@JoinColumn(name="fk_id_aplicacion")
	private Aplicacion idAplicacion;

	@Column(name="uri_ruta_aplicacion")
	private String uriRutaAplicacion;
	
	@Column(name="uri_ruta_aplicacion_producto")
	private String uriRutaAplicacionProducto;
	
	@Column(name="uri_ruta_aplicacion_producto_servicio")
	private String uriRutaAplicacionProductoServicio;
	
	@Column(name="parametro_ruta_aplicacion_producto_servicio")
	private String parametroRutaAplicacionProductoServicio;
	
	@Column(name="metodo_http")
	private String metodoHttp;
	
	@OrderBy
	@Column(name="estado_aplicacion_servicio")
	private Boolean estadoAplicacionServicio;
	
	@OneToMany(mappedBy="idAplicacionServicio") //el atributo de la clase
	private List<SeguridadAplicacionAcceso> seguridades_aplicaciones_accesos;

	public AplicacionServicio() {
		super();
	}
	
	public AplicacionServicio(Aplicacion idAplicacion) {
		super();
		this.idAplicacion = idAplicacion;
	}
	
	public AplicacionServicio(Aplicacion idAplicacion, String uriRutaAplicacion, String uriRutaAplicacionProducto,
			String uriRutaAplicacionProductoServicio, String parametroRutaAplicacionProductoServicio,
			String metodoHttp) {
		super();
		this.idAplicacion = idAplicacion;
		this.uriRutaAplicacion = uriRutaAplicacion;
		this.uriRutaAplicacionProducto = uriRutaAplicacionProducto;
		this.uriRutaAplicacionProductoServicio = uriRutaAplicacionProductoServicio;
		this.parametroRutaAplicacionProductoServicio = parametroRutaAplicacionProductoServicio;
		this.metodoHttp = metodoHttp;
	}

	public Integer getIdAplicacionServicio() {
		return idAplicacionServicio;
	}

	public void setIdAplicacionServicio(Integer idAplicacionServicio) {
		this.idAplicacionServicio = idAplicacionServicio;
	}

	public Aplicacion getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(Aplicacion idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public String getUriRutaAplicacion() {
		return uriRutaAplicacion;
	}

	public void setUriRutaAplicacion(String uriRutaAplicacion) {
		this.uriRutaAplicacion = uriRutaAplicacion;
	}

	public String getUriRutaAplicacionProducto() {
		return uriRutaAplicacionProducto;
	}

	public void setUriRutaAplicacionProducto(String uriRutaAplicacionProducto) {
		this.uriRutaAplicacionProducto = uriRutaAplicacionProducto;
	}

	public String getUriRutaAplicacionProductoServicio() {
		return uriRutaAplicacionProductoServicio;
	}

	public void setUriRutaAplicacionProductoServicio(String uriRutaAplicacionProductoServicio) {
		this.uriRutaAplicacionProductoServicio = uriRutaAplicacionProductoServicio;
	}

	public String getParametroRutaAplicacionProductoServicio() {
		return parametroRutaAplicacionProductoServicio;
	}

	public void setParametroRutaAplicacionProductoServicio(String parametroRutaAplicacionProductoServicio) {
		this.parametroRutaAplicacionProductoServicio = parametroRutaAplicacionProductoServicio;
	}

	public String getMetodoHttp() {
		return metodoHttp;
	}

	public void setMetodoHttp(String metodoHttp) {
		this.metodoHttp = metodoHttp;
	}

	public Boolean getEstadoAplicacionServicio() {
		return estadoAplicacionServicio;
	}

	public void setEstadoAplicacionServicio(Boolean estadoAplicacionServicio) {
		this.estadoAplicacionServicio = estadoAplicacionServicio;
	}

	public List<SeguridadAplicacionAcceso> getSeguridades_aplicaciones_accesos() {
		return seguridades_aplicaciones_accesos;
	}

	public void setSeguridades_aplicaciones_accesos(List<SeguridadAplicacionAcceso> seguridades_aplicaciones_accesos) {
		this.seguridades_aplicaciones_accesos = seguridades_aplicaciones_accesos;
	}
	
}
