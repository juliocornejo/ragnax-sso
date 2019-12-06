package com.ragnax.sso.entidad;

import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for @Entity: Empresa
 * en la base de Datos representa las empresas que pueden acceder a los servicios de la empresa Tesoro del Cielo.
 */
@Entity
@Table (name="empresa")

public class Empresa{
 
	@Id
	@OrderBy
	@Column(name="id_empresa")
	private Integer idEmpresa;
	@OrderBy
	@Column(name="rol_unico_identificador_empresa")
	private String rolUnicoIdentificadorEmpresa; //rut - ruc - dni
	
	@Column(name="nombre_empresa")
	private String nombreEmpresa; //nombre fantasia
	
	@Column(name="nombre_empresa_lower")
	private String nombreEmpresaLowerCase;
	
	@Column(name="dominio_empresa")
	private String dominioEmpresa;
	
	@Column(name="razon_social_empresa")
	private String razonSocialEmpresa; //nombre legal empresa
	
	@Column(name="razon_social_empresa_lower")
	private String razonSocialEmpresaLowerCase;
	
	@Column(name="giro_empresa")
	private String giroEmpresa; // accion que hace empresa
	
	@Column(name="direccion_origen")
	private String direccionOrigen;  // ubicacion legal empresa
	
	@Column(name="fk_id_pais_portal_empresa")
	private String codigoPaisPortal;
	
	@Column(name="id_region")
	private Integer idRegion;
	
	@Column(name="id_comuna")
	private Integer idComuna;
	
	@Column(name="ciudad_origen")
	private String ciudadOrigen;
	
	@OrderBy
	@Column(name="estado_empresa")
	private Boolean estadoEmpresa; 
	
	@OneToMany(mappedBy="idEmpresa")
	private List<EmpresaUsuario> empresas_usuarios;
	
	@OneToMany(mappedBy="idEmpresa")
	private List<EmpresaUsuario> aplicaciones_empresas;
	
	@OneToMany(mappedBy="idEmpresa")
	private List<ConfiguracionEmpresaUsuario> configuraciones_aplicaciones_usuarios;
	
	@OneToMany(mappedBy="idEmpresa")
	private List<MaquinaEmpresa> maquinas_empresas;
	
	public Empresa() {
		super();
	}
	
	public Empresa(Integer idEmpresa) {
		super();
		this.idEmpresa = idEmpresa;
	}
	
	public Empresa(String dominioEmpresa) {
		super();
		this.dominioEmpresa = dominioEmpresa;
	}
	
	public Empresa(String rolUnicoIdentificadorEmpresa, String nombreEmpresa, 
			String dominioEmpresa, String razonSocialEmpresa, String giroEmpresa,
			String direccionOrigen, String codigoPaisPortal, Integer idRegion, Integer idComuna, String ciudadOrigen) {
		super();
		this.rolUnicoIdentificadorEmpresa = rolUnicoIdentificadorEmpresa;
		this.nombreEmpresa = nombreEmpresa;
		this.dominioEmpresa = dominioEmpresa;
		this.razonSocialEmpresa = razonSocialEmpresa;
		this.giroEmpresa = giroEmpresa;
		this.direccionOrigen = direccionOrigen;
		this.codigoPaisPortal = codigoPaisPortal;
		this.idRegion = idRegion;
		this.idComuna = idComuna;
		this.ciudadOrigen = ciudadOrigen;
	}

	public Integer getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(Integer idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public String getRolUnicoIdentificadorEmpresa() {
		return rolUnicoIdentificadorEmpresa;
	}

	public void setRolUnicoIdentificadorEmpresa(String rolUnicoIdentificadorEmpresa) {
		this.rolUnicoIdentificadorEmpresa = rolUnicoIdentificadorEmpresa;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getNombreEmpresaLowerCase() {
		return nombreEmpresaLowerCase;
	}

	public void setNombreEmpresaLowerCase(String nombreEmpresaLowerCase) {
		this.nombreEmpresaLowerCase = nombreEmpresaLowerCase;
	}

	public String getDominioEmpresa() {
		return dominioEmpresa;
	}

	public void setDominioEmpresa(String dominioEmpresa) {
		this.dominioEmpresa = dominioEmpresa;
	}

	public String getRazonSocialEmpresa() {
		return razonSocialEmpresa;
	}

	public void setRazonSocialEmpresa(String razonSocialEmpresa) {
		this.razonSocialEmpresa = razonSocialEmpresa;
	}

	public String getRazonSocialEmpresaLowerCase() {
		return razonSocialEmpresaLowerCase;
	}

	public void setRazonSocialEmpresaLowerCase(String razonSocialEmpresaLowerCase) {
		this.razonSocialEmpresaLowerCase = razonSocialEmpresaLowerCase;
	}

	public String getGiroEmpresa() {
		return giroEmpresa;
	}

	public void setGiroEmpresa(String giroEmpresa) {
		this.giroEmpresa = giroEmpresa;
	}

	public String getDireccionOrigen() {
		return direccionOrigen;
	}

	public void setDireccionOrigen(String direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}
	
	public String getCodigoPaisPortal() {
		return codigoPaisPortal;
	}

	public void setCodigoPaisPortal(String codigoPaisPortal) {
		this.codigoPaisPortal = codigoPaisPortal;
	}

	public Integer getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(Integer idRegion) {
		this.idRegion = idRegion;
	}

	public Integer getIdComuna() {
		return idComuna;
	}

	public void setIdComuna(Integer idComuna) {
		this.idComuna = idComuna;
	}

	public String getCiudadOrigen() {
		return ciudadOrigen;
	}

	public void setCiudadOrigen(String ciudadOrigen) {
		this.ciudadOrigen = ciudadOrigen;
	}

	public Boolean getEstadoEmpresa() {
		return estadoEmpresa;
	}

	public void setEstadoEmpresa(Boolean estadoEmpresa) {
		this.estadoEmpresa = estadoEmpresa;
	}

	public List<EmpresaUsuario> getEmpresas_usuarios() {
		return empresas_usuarios;
	}

	public void setEmpresas_usuarios(List<EmpresaUsuario> empresas_usuarios) {
		this.empresas_usuarios = empresas_usuarios;
	}

	public List<EmpresaUsuario> getAplicaciones_empresas() {
		return aplicaciones_empresas;
	}

	public void setAplicaciones_empresas(List<EmpresaUsuario> aplicaciones_empresas) {
		this.aplicaciones_empresas = aplicaciones_empresas;
	}

	public List<ConfiguracionEmpresaUsuario> getConfiguraciones_aplicaciones_usuarios() {
		return configuraciones_aplicaciones_usuarios;
	}

	public void setConfiguraciones_aplicaciones_usuarios(
			List<ConfiguracionEmpresaUsuario> configuraciones_aplicaciones_usuarios) {
		this.configuraciones_aplicaciones_usuarios = configuraciones_aplicaciones_usuarios;
	}

	public List<MaquinaEmpresa> getMaquinas_empresas() {
		return maquinas_empresas;
	}

	public void setMaquinas_empresas(List<MaquinaEmpresa> maquinas_empresas) {
		this.maquinas_empresas = maquinas_empresas;
	}
	
}
