package com.ragnax.sso.servicio.utilidades;

import java.util.ArrayList;
import java.util.List;

import com.ragnax.sso.entidad.Usuario;

public class SSOUtilidades {
	
	public static List<String> crearListaCadenaCodigoUsuario(Usuario objUsuario){
		
		List<String> listaCadena = new ArrayList<String>();
		
		String codigoUsuario = objUsuario.getIdMember().getIdMember()+""+ objUsuario.getIdPerfil().getIdPerfil();

		codigoUsuario = codigoUsuario.trim();
		codigoUsuario = codigoUsuario.replace("\\s", "").replace(" ", "");
		codigoUsuario = codigoUsuario.toLowerCase();
		
		listaCadena.add(codigoUsuario);
		
		return listaCadena; 
	}
	
//	public String obtenerCodigoUsuario(Usuario objUsuario){
//		
//		List<String> listaCadena = new ArrayList<String>();
//		
//		try {
//			if(objUsuario.getIdMember().getIdMember()!=null &&
//
//					objUsuario.getIdPerfil().getIdPerfil()>0) {
//				//Validar que no exista la combinacion del, negocio, tipo de fee y el nombre de ese cargo.
//
//				String codigoUsuario = objUsuario.getIdMember().getIdMember()+""+ objUsuario.getIdPerfil().getIdPerfil();
//
//				codigoUsuario = codigoUsuario.trim();
//				codigoUsuario = codigoUsuario.replace("\\s", "").replace(" ", "");
//				codigoUsuario = codigoUsuario.toLowerCase();
//				
//				listaCadena.add(codigoUsuario);
//				
//				return zapalaClienteRest.generarCodigoByNumero(new ZapalaRequest(listaCadena)).getCodigoGenerado();
//
//			}
//
//		} catch (Exception e) {
//			return null;
//		}
//
//		return null;
//	}
	
	
	
} 
