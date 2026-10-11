package co.com.saraitel.gestionsaraitel.transversal.excepciones;

import co.com.saraitel.gestionsaraitel.transversal.excepciones.enums.Capa;

public class GestionsaraitelTransversalException extends GestionSaraitelException{

	private static final long serialVersionUID = 1978888237473844746L;

	private GestionsaraitelTransversalException(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.TRANVERSAL, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		// TODO Auto-generated constructor stub
	}
	public static GestionSaraitelException crear(String mensajeUsuario) {
		return new GestionsaraitelTransversalException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static GestionSaraitelException crear(String mensajeUsuario, String mensajeTecnico) {
		return new GestionsaraitelTransversalException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static GestionSaraitelException crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new GestionsaraitelTransversalException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, excepcionRaiz);	
	}
}

