package co.com.saraitel.gestionsaraitel.transversal.excepciones;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.enums.Capa;

public class GestionSaraitelFachadaExcepcion extends GestionSaraitelExcepcion {

	private static final long serialVersionUID = 6880156496944448624L;

	private GestionSaraitelFachadaExcepcion(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.FACHADA, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		// TODO Auto-generated constructor stub
	}
	
	public static GestionSaraitelExcepcion crear(String mensajeUsuario) {
		return new GestionSaraitelFachadaExcepcion(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static GestionSaraitelExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new GestionSaraitelFachadaExcepcion(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static GestionSaraitelExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new GestionSaraitelFachadaExcepcion(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, excepcionRaiz);	
	}
}