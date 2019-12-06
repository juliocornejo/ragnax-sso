package com.ragnax.sso.entidad;

import java.util.List;

import javax.persistence.*;

/**
 *  implementation class for @Entity: Usuario
 * en la base de Datos representa el registro de las personas asociadas al servicio.
 */
@Entity
@Table (name="usuario_unit")

public class Usuario{
 
	@Id
	@OrderBy
	@Column(name="id_usuario")
	private Integer idUsuario;
	
	@Column(name="codigo_usuario_unit")
	private String codigoUsuarioUnit;
	
	@ManyToOne(targetEntity = Member.class, fetch=FetchType.EAGER)
	@JoinColumn(name="fk_id_member")
	private Member idMember;
	//Un usuario jcornej solo puede estar en una Persona "member"
	//pero una Persona "member" puede tener muchos usuarios.
	@ManyToOne(targetEntity = Perfil.class, fetch=FetchType.EAGER)
	@JoinColumn(name="fk_id_perfil")
	private Perfil idPerfil;
	
	//Un usuario jcornej solo puede estar en una Persona "member"
	//pero una Persona "member" puede tener muchos usuarios.
	@OneToMany(mappedBy="idUsuario")
	private List<EmpresaUsuario> empresas_usuarios;
	
	public Usuario() {
		super();
	}
	
	public Usuario(Member idMember, Perfil idPerfil) {
		super();
		this.idMember = idMember;
		this.idPerfil = idPerfil;
	}

	public Usuario(Integer idUsuario) {
		super();
		this.idUsuario = idUsuario;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getCodigoUsuarioUnit() {
		return codigoUsuarioUnit;
	}

	public void setCodigoUsuarioUnit(String codigoUsuarioUnit) {
		this.codigoUsuarioUnit = codigoUsuarioUnit;
	}

	public Member getIdMember() {
		return idMember;
	}

	public void setIdMember(Member idMember) {
		this.idMember = idMember;
	}

	public Perfil getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Perfil idPerfil) {
		this.idPerfil = idPerfil;
	}

	public List<EmpresaUsuario> getEmpresas_usuarios() {
		return empresas_usuarios;
	}

	public void setEmpresas_usuarios(List<EmpresaUsuario> empresas_usuarios) {
		this.empresas_usuarios = empresas_usuarios;
	}
}
