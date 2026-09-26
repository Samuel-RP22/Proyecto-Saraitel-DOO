package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOTransversalException extends libreriaUCOExcepcion{

	private static final long serialVersionUID = 1978888237473844746L;

	private LibreriaUCOTransversalException(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.TRANVERSAL, mensajeUsuario, mensajeTecnico, excepcionRaiz);
		// TODO Auto-generated constructor stub
	}

}
