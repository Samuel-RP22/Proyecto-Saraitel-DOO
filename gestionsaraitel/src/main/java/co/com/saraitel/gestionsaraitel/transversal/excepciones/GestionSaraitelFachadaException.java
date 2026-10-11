package co.com.saraitel.gestionsaraitel.transversal.excepciones;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.enums.Capa;

public class GestionSaraitelFachadaException extends GestionSaraitelException {

	private static final long serialVersionUID = 6880156496944448624L;

	private GestionSaraitelFachadaException(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.FACHADA, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		// TODO Auto-generated constructor stub
	}
	
	public static GestionSaraitelException crear(String mensajeUsuario) {
		return new GestionSaraitelFachadaException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static GestionSaraitelException crear(String mensajeUsuario, String mensajeTecnico) {
		return new GestionSaraitelFachadaException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static GestionSaraitelException crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new GestionSaraitelFachadaException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, excepcionRaiz);	
	}
}