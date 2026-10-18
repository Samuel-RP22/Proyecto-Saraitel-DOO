package co.com.saraitel.gestionsaraitel.transversal.excepciones;

import co.com.saraitel.gestionsaraitel.transversal.excepciones.enums.Capa;

public class GestionSaraitelDatosExcepcion extends GestionSaraitelExcepcion {

	private static final long serialVersionUID = 2781462033546993220L;

	private GestionSaraitelDatosExcepcion(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DATOS, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		// TODO Auto-generated constructor stub
	}
	public static GestionSaraitelExcepcion crear(String mensajeUsuario) {
		return new GestionSaraitelDatosExcepcion(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static GestionSaraitelExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new GestionSaraitelDatosExcepcion(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static GestionSaraitelExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new GestionSaraitelDatosExcepcion(Capa.CONTROLADOR, mensajeUsuario, 
				mensajeTecnico, excepcionRaiz);	
	}
}
