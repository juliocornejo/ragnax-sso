package com.ragnax.sso.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ragnax.sso.entidad.Genero;
import com.ragnax.sso.entidad.Member;


public interface MemberRepository extends JpaRepository<Member, Integer> {
	
	List<Member> findByIdGenero(Genero idGenero);
	
	List<Member> findByNombreMemberLike(String nombreMember);
	
	List<Member> findByApellidoPaternoMemberLike (String apellidoPaternoMember);
	
	List<Member> findByTelefonoContactoMemberLike(String telefonoContactoMember);
	
	List<Member> findByFechaNacimientoMember(String fechaNacimientoMember);
	
	List<Member> findByCreacionMemberBetween(Timestamp creacionMemberA, Timestamp creacionMemberB);
}
