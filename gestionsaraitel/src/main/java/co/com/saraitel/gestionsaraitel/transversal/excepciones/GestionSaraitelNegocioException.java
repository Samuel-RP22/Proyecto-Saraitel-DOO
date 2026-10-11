package co.com.saraitel.gestionsaraitel.transversal.excepciones;

import co.com.saraitel.gestionsaraitel.transversal.excepciones.enums.Capa;

public class GestionSaraitelNegocioException extends GestionSaraitelException{

	private static final long serialVersionUID = 6949641476561644361L;

	private GestionSaraitelNegocioException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.NEGOCIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	public static GestionSaraitelException crear(String mensajeUsuario) {
		return new GestionSaraitelNegocioException(mensajeUsuario, 
				mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static GestionSaraitelException crear(String mensajeUsuario, String mensajeTecnico) {
		return new GestionSaraitelNegocioException(mensajeUsuario, 
				mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static GestionSaraitelException crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new GestionSaraitelNegocioException(mensajeUsuario, 
				mensajeTecnico, excepcionRaiz);	
	}
}
