package co.com.saraitel.gestionsaraitel.transversal.excepciones;

import co.com.saraitel.gestionsaraitel.transversal.excepciones.enums.Capa;

public class GestionsaraitelNegocioException extends GestionsaraitelExcepcion{

	private static final long serialVersionUID = 6949641476561644361L;

	private GestionsaraitelNegocioException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.NEGOCIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	public static GestionsaraitelExcepcion crear(String mensajeUsuario) {
		return new GestionsaraitelNegocioException(mensajeUsuario, 
				mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static GestionsaraitelExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new GestionsaraitelNegocioException(mensajeUsuario, 
				mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static GestionsaraitelExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new GestionsaraitelNegocioException(mensajeUsuario, 
				mensajeTecnico, excepcionRaiz);	
	}
}
