package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas;

import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;
import co.com.saraitel.gestionsaraitel.transversal.utilitarios.UtilObjeto;

public interface Rule<O> {

	void ejecutar(@SuppressWarnings("unchecked") O... datos);

	static <O> void asegurarCantidadDatos(final O[] datos, final int cantidadEsperada) {
		if (UtilObjeto.esNulo(datos) || datos.length < cantidadEsperada) {
			var mensajeUsuario = CatalogoMensajes.Rule.USUARIO_ERROR_DATOS_INCOMPLETOS_PARA_VALIDAR_REGLA;
			var mensajeTecnico = CatalogoMensajes.Rule.TECNICO_ERROR_CANTIDAD_DATOS_REGLA_NO_VALIDA;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario, mensajeTecnico);
		}
	}
}