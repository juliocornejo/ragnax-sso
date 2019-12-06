package com.ragnax.sso.repository;

public interface FactorySeguridadDAO {
	
	public AccionPerfilRepository getAccionPerfilRepository();
	public AplicacionEmpresaRepository getAplicacionEmpresaRepository();
	public AplicacionRepository getAplicacionRepository();
	public AplicacionRolRepository getAplicacionRolRepository();
	public AplicacionServicioRepository getAplicacionServicioRepository();
	public ConfiguracionEmpresaUsuarioRepository getConfiguracionEmpresaUsuarioRepository();
	public EmpresaRepository getEmpresaRepository();
	public EmpresaUsuarioAplicacionEmpresaRepository getEmpresaUsuarioAplicacionEmpresaRepository();
	public EmpresaUsuarioRepository getEmpresaUsuarioRepository();
	public FotoPerfilRepository getFotoPerfilRepository();
	public GeneroRepository getGeneroRepository();
	public IdentificadorRepository getIdentificadorRepository();
	public MaquinaEmpresaRepository getMaquinaEmpresaRepository();
	public MaquinaRepository getMaquinaRepository();
	public MemberRepository getMemberRepository();
	public PerfilRepository getPerfilRepository();
	public RolRepository getRolRepository();
	public SeguridadAplicacionAccesoRepository getSeguridadAplicacionAccesoRepository();
	public SeguridadSessionPlataformaRepository getSeguridadSessionPlataformaRepository();
	public TipoAccionPerfilRepository getTipoAccionPerfilRepository();
	public UsuarioRepository getUsuarioRepository();
	
}
