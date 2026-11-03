package co.com.saraitel.gestionsaraitel.transversal.excepciones;

import co.com.saraitel.gestionsaraitel.transversal.excepciones.enums.Capa;

public class GestionSaraitelTransversalExcepcion extends GestionSaraitelExcepcion {

	private static final long serialVersionUID = 1978888237473844746L;

	private GestionSaraitelTransversalExcepcion(String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		super(Capa.TRANSVERSAL, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

	public static GestionSaraitelExcepcion crear(String mensajeUsuario) {
		return new GestionSaraitelTransversalExcepcion(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));
	}

	public static GestionSaraitelExcepcion crear(String mensajeUsuario, String mensajeTecnico) {
		return new GestionSaraitelTransversalExcepcion(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));
	}

	public static GestionSaraitelExcepcion crear(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		return new GestionSaraitelTransversalExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
}
