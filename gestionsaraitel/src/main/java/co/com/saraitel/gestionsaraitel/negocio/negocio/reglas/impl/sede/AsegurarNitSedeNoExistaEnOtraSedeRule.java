package co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.impl.sede;

import java.util.UUID;

import co.com.saraitel.gestionsaraitel.dao.factoria.DAOFactory;
import co.com.saraitel.gestionsaraitel.entidad.SedeEntidad;
import co.com.saraitel.gestionsaraitel.negocio.negocio.reglas.Rule;
import co.com.saraitel.gestionsaraitel.transversal.catalogo.CatalogoMensajes;
import co.com.saraitel.gestionsaraitel.transversal.excepciones.GestionSaraitelNegocioExcepcion;

public class AsegurarNitSedeNoExistaEnOtraSedeRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarNitSedeNoExistaEnOtraSedeRule();

	private AsegurarNitSedeNoExistaEnOtraSedeRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {
		Rule.asegurarCantidadDatos(datos, 3);

		var idSede = (UUID) datos[0];
		var nitSede = (String) datos[1];
		var daoFactory = (DAOFactory) datos[2];

		var entidadFiltro = new SedeEntidad();
		entidadFiltro.setNit(nitSede);

		var resultados = daoFactory.obtenerSedeDao().consultarPorFiltro(entidadFiltro);

		if (resultados.stream().anyMatch(sede -> !sede.getId().equals(idSede))) {
			var mensajeUsuario = CatalogoMensajes.SedeNegocioImpl.NIT_SEDE_YA_EXISTE_EN_OTRA_SEDE;
			throw GestionSaraitelNegocioExcepcion.crear(mensajeUsuario);
		}
	}
}
