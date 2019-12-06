package com.ragnax.sso.entidad;

import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for @Entity: Maquina
 * en la base de Datos representa las empresas que pueden acceder a los servicios de la empresa Tesoro del Cielo.
 */
@Entity
@Table (name="maquina")

public class Maquina{
 
	@Id
	@OrderBy
	@Column(name="id_maquina")
	private Integer idMaquina;
	@OrderBy
	@Column(name="direccion_ip_maquina")
	private String direccionIpMaquina;
	
	@Column(name="nombre_ip_maquina")
	private String nombreIpMaquina; //nombre fantasia
	
	@OneToMany(mappedBy="idMaquina")
	private List<MaquinaEmpresa> maquinas_empresas;
	
	public Maquina() {
		super();
	}

	public Integer getIdMaquina() {
		return idMaquina;
	}

	public void setIdMaquina(Integer idMaquina) {
		this.idMaquina = idMaquina;
	}

	public String getDireccionIpMaquina() {
		return direccionIpMaquina;
	}

	public void setDireccionIpMaquina(String direccionIpMaquina) {
		this.direccionIpMaquina = direccionIpMaquina;
	}

	public String getNombreIpMaquina() {
		return nombreIpMaquina;
	}

	public void setNombreIpMaquina(String nombreIpMaquina) {
		this.nombreIpMaquina = nombreIpMaquina;
	}

	public List<MaquinaEmpresa> getMaquinas_empresas() {
		return maquinas_empresas;
	}

	public void setMaquinas_empresas(List<MaquinaEmpresa> maquinas_empresas) {
		this.maquinas_empresas = maquinas_empresas;
	}
}
