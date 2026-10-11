package co.com.saraitel.gestionsaraitel.transversal.excepciones;

import co.com.saraitel.gestionsaraitel.transversal.excepciones.enums.Capa;

public class GestionSaraitelEntidadException extends GestionSaraitelException{

	private static final long serialVersionUID = -7590601780650092844L;

	private GestionSaraitelEntidadException(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.ENTIDAD, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		// TODO Auto-generated constructor stub
	}
	public static GestionSaraitelException crear(String mensajeUsuario) {
		return new GestionSaraitelEntidadException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static GestionSaraitelException crear(String mensajeUsuario, String mensajeTecnico) {
		return new GestionSaraitelEntidadException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static GestionSaraitelException crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new GestionSaraitelEntidadException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, excepcionRaiz);	
	}
}

