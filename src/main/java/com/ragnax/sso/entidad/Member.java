package com.ragnax.sso.entidad;

import java.lang.String;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for @Entity: Member
 * en la base de Datos representa el detalle de las personas registradas para el servicio de SSO.
 */
@Entity
@Table (name="member_usuariounit")

public class Member{
 
	@Id
	@OrderBy
	@Column(name="id_member")
	private Integer idMember;
	
	@OrderBy
	@Column(name="nombre_member")
	private String nombreMember;//Nombre de la Persona
	
	@Column(name="apellido_paterno_member")
	private String apellidoPaternoMember; //Apellido de la Persona
	
	@Column(name="apellido_materno_member")
	private String apellidoMaternoMember; //Apellido de la Persona
	
	@Column(name="telefono_contacto_member")
	private String telefonoContactoMember;
	
	@Column(name="fecha_nacimiento_member")
	private String fechaNacimientoMember;
	
	@Column(name="firma_member")
	private String firmaMember;
	
	@Column(name="creacion_member")
	private Timestamp creacionMember;
	
	@ManyToOne(targetEntity=Genero.class, fetch=FetchType.EAGER)
	@JoinColumn(name="fk_id_genero")
	private Genero idGenero;
	
	@OneToMany(mappedBy = "idMember", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval=true)
	private List<Identificador> identificador_member;
	
	@OneToMany(mappedBy = "idMember", cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, orphanRemoval=true)
	private List<Usuario> usuarios_member;
	
	public Member() {
		super();
	}
	
	public Member(String nombreMember, String apellidoPaternoMember,
			String apellidoMaternoMember, String telefonoContactoMember, String fechaNacimientoMember,
			String firmaMember, Genero idGenero) {
		super();
		this.nombreMember = nombreMember;
		this.apellidoPaternoMember = apellidoPaternoMember;
		this.apellidoMaternoMember = apellidoMaternoMember;
		this.telefonoContactoMember = telefonoContactoMember;
		this.fechaNacimientoMember = fechaNacimientoMember;
		this.firmaMember = firmaMember;
		this.idGenero = idGenero;
	}



	public Integer getIdMember() {
		return idMember;
	}

	public void setIdMember(Integer idMember) {
		this.idMember = idMember;
	}

	public String getNombreMember() {
		return nombreMember;
	}

	public void setNombreMember(String nombreMember) {
		this.nombreMember = nombreMember;
	}

	public String getApellidoPaternoMember() {
		return apellidoPaternoMember;
	}

	public void setApellidoPaternoMember(String apellidoPaternoMember) {
		this.apellidoPaternoMember = apellidoPaternoMember;
	}

	public String getApellidoMaternoMember() {
		return apellidoMaternoMember;
	}

	public void setApellidoMaternoMember(String apellidoMaternoMember) {
		this.apellidoMaternoMember = apellidoMaternoMember;
	}

	public String getTelefonoContactoMember() {
		return telefonoContactoMember;
	}

	public void setTelefonoContactoMember(String telefonoContactoMember) {
		this.telefonoContactoMember = telefonoContactoMember;
	}

	public String getFechaNacimientoMember() {
		return fechaNacimientoMember;
	}

	public void setFechaNacimientoMember(String fechaNacimientoMember) {
		this.fechaNacimientoMember = fechaNacimientoMember;
	}

	public String getFirmaMember() {
		return firmaMember;
	}

	public void setFirmaMember(String firmaMember) {
		this.firmaMember = firmaMember;
	}

	public Timestamp getCreacionMember() {
		return creacionMember;
	}

	public void setCreacionMember(Timestamp creacionMember) {
		this.creacionMember = creacionMember;
	}

	public Genero getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Genero idGenero) {
		this.idGenero = idGenero;
	}

	public List<Identificador> getIdentificador_member() {
		return identificador_member;
	}

	public void setIdentificador_member(List<Identificador> identificador_member) {
		this.identificador_member = identificador_member;
	}

	public List<Usuario> getUsuarios_member() {
		return usuarios_member;
	}

	public void setUsuarios_member(List<Usuario> usuarios_member) {
		this.usuarios_member = usuarios_member;
	}
	
}
