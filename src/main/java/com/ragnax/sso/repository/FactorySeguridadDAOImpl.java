package com.ragnax.sso.repository;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Repository;

@Repository
public class FactorySeguridadDAOImpl implements FactorySeguridadDAO {

	@Autowired
	private AccionPerfilRepository accionPerfilRepository;	
	
	public AccionPerfilRepository getAccionPerfilRepository() {
		return accionPerfilRepository;
	}
	
	@Autowired
	private AplicacionEmpresaRepository aplicacionEmpresaRepository;	
	
	public AplicacionEmpresaRepository getAplicacionEmpresaRepository() {
		return aplicacionEmpresaRepository;
	}
	
	@Autowired
	private AplicacionRepository aplicacionRepository;	
	
	public AplicacionRepository getAplicacionRepository() {
		return aplicacionRepository;
	}
	
	@Autowired
	private AplicacionRolRepository aplicacionRolRepository;	
	
	public AplicacionRolRepository getAplicacionRolRepository() {
		return aplicacionRolRepository;
	}
	
	@Autowired
	private AplicacionServicioRepository aplicacionServicioRepository;	
	
	public AplicacionServicioRepository getAplicacionServicioRepository() {
		return aplicacionServicioRepository;
	}
	
	@Autowired
	private ConfiguracionEmpresaUsuarioRepository configuracionEmpresaUsuarioRepository;	
	
	public ConfiguracionEmpresaUsuarioRepository getConfiguracionEmpresaUsuarioRepository() {
		return configuracionEmpresaUsuarioRepository;
	}
	
	@Autowired
	private EmpresaRepository empresaRepository;	
	
	public EmpresaRepository getEmpresaRepository() {
		return empresaRepository;
	}
	
	@Autowired
	private EmpresaUsuarioAplicacionEmpresaRepository empresaUsuarioAplicacionEmpresaRepository;	
	
	public EmpresaUsuarioAplicacionEmpresaRepository getEmpresaUsuarioAplicacionEmpresaRepository() {
		return empresaUsuarioAplicacionEmpresaRepository;
	}
	
	@Autowired
	private EmpresaUsuarioRepository empresaUsuarioRepository;	
	
	public EmpresaUsuarioRepository getEmpresaUsuarioRepository() {
		return empresaUsuarioRepository;
	}
	
	@Autowired
	private FotoPerfilRepository fotoPerfilRepository;	
	
	public FotoPerfilRepository getFotoPerfilRepository() {
		return fotoPerfilRepository;
	}
	
	@Autowired
	private GeneroRepository generoRepository;	
	
	public GeneroRepository getGeneroRepository() {
		return generoRepository;
	}
	
	@Autowired
	private IdentificadorRepository identificadorRepository;	
	
	public IdentificadorRepository getIdentificadorRepository() {
		return identificadorRepository;
	}
	
	@Autowired
	private MaquinaEmpresaRepository maquinaEmpresaRepository;	
	
	public MaquinaEmpresaRepository getMaquinaEmpresaRepository() {
		return maquinaEmpresaRepository;
	}
	
	@Autowired
	private MaquinaRepository maquinaRepository;	
	
	public MaquinaRepository getMaquinaRepository() {
		return maquinaRepository;
	}
	
	@Autowired
	private MemberRepository memberRepository;	
	
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
	
	@Autowired
	private PerfilRepository perfilRepository;	
	
	public PerfilRepository getPerfilRepository() {
		return perfilRepository;
	}
	
	@Autowired
	private RolRepository rolRepository;	
	
	public RolRepository getRolRepository() {
		return rolRepository;
	}
	
	@Autowired
	private SeguridadAplicacionAccesoRepository seguridadAplicacionAccesoRepository;	
	
	public SeguridadAplicacionAccesoRepository getSeguridadAplicacionAccesoRepository() {
		return seguridadAplicacionAccesoRepository;
	}
	
	@Autowired
	private SeguridadSessionPlataformaRepository seguridadSessionPlataformaRepository;	
	
	public SeguridadSessionPlataformaRepository getSeguridadSessionPlataformaRepository() {
		return seguridadSessionPlataformaRepository;
	}
	
	@Autowired
	private TipoAccionPerfilRepository tipoAccionPerfilRepository;	
	
	public TipoAccionPerfilRepository getTipoAccionPerfilRepository() {
		return tipoAccionPerfilRepository;
	}

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public UsuarioRepository getUsuarioRepository() {
		return usuarioRepository;
	}
}
