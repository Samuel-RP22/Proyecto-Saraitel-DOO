package co.edu.uco.libreriauco.transversal.excepciones;
import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class libreriaUCOExcepcion extends RuntimeException {
	
	private static final long serialVersionUID = 5239576382867557534L;
	private Capa capa;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private Exception excepcionRaiz;
	
	protected libreriaUCOExcepcion(Capa capa, 
			String mensajeUsuario, 
			String mensajeTecnico, 
			Exception excepcionRaiz) {
		super();
		setCapa(capa);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
		setExcepcionRaiz(excepcionRaiz);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	private void setCapa(Capa capa) {
		this.capa = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(capa, Capa.GENERAL);
	}

	private void setMensajeUsuario(String mensajeUsuario) {
		this.mensajeUsuario = UtilTexto.getUtilTexto().obtenerValorDefecto(mensajeUsuario);
	}

	private void setMensajeTecnico(String mensajeTecnico) {
		this.mensajeTecnico = UtilTexto.getUtilTexto().obtenerValorDefecto(mensajeTecnico, getMensajeUsuario());
	}

	private void setExcepcionRaiz(Exception excepcionRaiz) {
		this.excepcionRaiz = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(excepcionRaiz, new Exception(getMensajeTecnico()));
	}
	
}