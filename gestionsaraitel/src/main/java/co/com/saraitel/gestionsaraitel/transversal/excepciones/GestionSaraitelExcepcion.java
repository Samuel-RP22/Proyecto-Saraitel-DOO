package co.com.saraitel.gestionsaraitel.transversal.excepciones;

import co.com.saraitel.gestionsaraitel.transversal.excepciones.enums.Capa;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilTexto;

public class GestionSaraitelExcepcion extends RuntimeException {

	private static final long serialVersionUID = 5239576382867557534L;
	private final Capa capa;
	private final String mensajeUsuario;
	private final String mensajeTecnico;
	private final Exception excepcionRaiz;

	protected GestionSaraitelExcepcion(Capa capa, String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		var usuarioFinal = UtilTexto.obtenerValorDefecto(mensajeUsuario);
		var tecnicoFinal = UtilTexto.obtenerValorDefecto(mensajeTecnico, usuarioFinal);
		var raizFinal = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(excepcionRaiz, new Exception(tecnicoFinal));

		super(tecnicoFinal, raizFinal);

		this.capa = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(capa, Capa.GENERAL);
		this.mensajeUsuario = usuarioFinal;
		this.mensajeTecnico = tecnicoFinal;
		this.excepcionRaiz = raizFinal;
	}

	public Capa getCapa() {
		return capa;
	}

	public String getMensajeUsuario() {
		return mensajeUsuario;
	}

	public String getMensajeTecnico() {
		return mensajeTecnico;
	}

	public Exception getExcepcionRaiz() {
		return excepcionRaiz;
	}
}