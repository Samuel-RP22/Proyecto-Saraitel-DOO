package co.com.saraitel.gestionsaraitel.transversal.excepciones;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.enums.Capa;

public class GestionsaraitelControladorException extends GestionSaraitelException {

	private static final long serialVersionUID = 6880156496944448624L;

	private GestionsaraitelControladorException(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.CONTROLADOR, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		// TODO Auto-generated constructor stub
	}
	
	public static GestionSaraitelException crear(String mensajeUsuario) {
		return new GestionsaraitelControladorException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static GestionSaraitelException crear(String mensajeUsuario, String mensajeTecnico) {
		return new GestionsaraitelControladorException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static GestionSaraitelException crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new GestionsaraitelControladorException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, excepcionRaiz);	
	}
}