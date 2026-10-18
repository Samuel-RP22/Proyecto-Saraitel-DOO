package co.com.saraitel.gestionsaraitel.transversal.excepciones;

import co.com.saraitel.gestionsaraitel.transversal.excepciones.enums.Capa;

public class GestionSaraitelDominioExcepcion extends GestionSaraitelExcepcion {

	private static final long serialVersionUID = -2052038437911576926L;

	private GestionSaraitelDominioExcepcion(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DOMINIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		// TODO Auto-generated constructor stub
	}

	public static GestionSaraitelExcepcion crear(String mensajeUsuario) {
		return new GestionSaraitelDominioExcepcion(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static GestionSaraitelExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new GestionSaraitelDominioExcepcion(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static GestionSaraitelExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new GestionSaraitelDominioExcepcion(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, excepcionRaiz);	
	}
}
