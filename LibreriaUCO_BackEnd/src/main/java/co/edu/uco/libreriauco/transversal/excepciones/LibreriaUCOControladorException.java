package co.edu.uco.libreriauco.transversal.excepciones;
import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOControladorException extends libreriaUCOExcepcion {

	private static final long serialVersionUID = 6880156496944448624L;

	private LibreriaUCOControladorException(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.CONTROLADOR, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		// TODO Auto-generated constructor stub
	}
	
	public static libreriaUCOExcepcion crear(String mensajeUsuario) {
		return new LibreriaUCOControladorException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static libreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCOControladorException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static libreriaUCOExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new LibreriaUCOControladorException(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, excepcionRaiz);	
	}
}