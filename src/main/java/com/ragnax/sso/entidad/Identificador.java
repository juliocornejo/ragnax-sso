package com.ragnax.sso.entidad;

import java.lang.String;

import javax.persistence.*;

/**
 *  implementation class for @Entity: Identificador
 * en la base de Datos representa el detalle de las personas registradas para el servicio de SSO.
 */
@Entity
@Table (name="identificador")

public class Identificador{
 
	@Id
	@OrderBy
	@Column(name="id_identificador")
	private Integer idIdentificador;
	
	@Column(name="nombre_identificador")
	private String nombreIdentificador;
	
	@Column(name="value_identificador")
	private String valueIdentificador;
	
	@Column(name="fk_id_pais_portal_identificador")
	private String codigoPaisPortal;
	
	@ManyToOne(targetEntity=Member.class, fetch=FetchType.EAGER)
	@JoinColumn(name="fk_id_member")
	private Member idMember;
	
	public Identificador() {
		super();
	}
	
	public Identificador(String nombreIdentificador, String valueIdentificador, String codigoPaisPortal,
			Member idMember) {
		super();
		this.nombreIdentificador = nombreIdentificador;
		this.valueIdentificador = valueIdentificador;
		this.codigoPaisPortal = codigoPaisPortal;
		this.idMember = idMember;
	}

	public Integer getIdIdentificador() {
		return idIdentificador;
	}

	public void setIdIdentificador(Integer idIdentificador) {
		this.idIdentificador = idIdentificador;
	}

	public String getNombreIdentificador() {
		return nombreIdentificador;
	}

	public void setNombreIdentificador(String nombreIdentificador) {
		this.nombreIdentificador = nombreIdentificador;
	}

	public String getValueIdentificador() {
		return valueIdentificador;
	}

	public void setValueIdentificador(String valueIdentificador) {
		this.valueIdentificador = valueIdentificador;
	}

	public String getCodigoPaisPortal() {
		return codigoPaisPortal;
	}

	public void setCodigoPaisPortal(String codigoPaisPortal) {
		this.codigoPaisPortal = codigoPaisPortal;
	}

	public Member getIdMember() {
		return idMember;
	}

	public void setIdMember(Member idMember) {
		this.idMember = idMember;
	}
	
}
